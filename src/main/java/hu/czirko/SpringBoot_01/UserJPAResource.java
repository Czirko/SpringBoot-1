package hu.czirko.SpringBoot_01;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import hu.czirko.SpringBoot_01.error.UserNotFoundException;
import hu.czirko.SpringBoot_01.jpa.PersonDaoService;
import hu.czirko.SpringBoot_01.jpa.PostRepository;
import hu.czirko.SpringBoot_01.model.domain.Person;
import hu.czirko.SpringBoot_01.model.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/userjpa")
public class UserJPAResource {
    @Autowired
    private PersonDaoService service;
    @Autowired
    private PostRepository postRepo;


    @GetMapping(path = "/all")
    public List<Person> retrieveAllUsers() {
        return service.findAll();
    }

    @PostMapping("/add")
    public Person addUser(@Valid @RequestBody Person p) {

        return service.addUser(p);
    }

    @GetMapping("/{id}")
    public EntityModel<Person> retrieveUser(@PathVariable int id) {
        Person user = service.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundException("id-" + id));

        //HATEOAS
        EntityModel<Person> resource = EntityModel.of(user);
        WebMvcLinkBuilder linkTo =
                linkTo(methodOn(this.getClass()).retrieveAllUsers());
        resource.add(linkTo.withRel("all-users"));
        return resource;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        service.deleteById(id);
    }

    @GetMapping("/{id}/posts")
    public Set<Post> getPosts(@PathVariable int id) {
        Person p = service.findById(id)
                .orElseThrow(() -> new UserNotFoundException(
                        "There is no user with Id:" + id
                ));
        return p.getPosts();
    }

    @PostMapping("/{id}/post")
    public ResponseEntity<Object> createPost
            (@PathVariable int id, @RequestBody Post p) {
        Person person = service.findById(id)
                .orElseThrow(
                        () -> new UserNotFoundException(
                                "No User with Id:-" + id
                        )
                );
        p.setPerson(person);
        postRepo.save(p);

        URI loc = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(p.getId())
                .toUri();

        return ResponseEntity.created(loc).build();
    }

}
