package hu.czirko.SpringBoot_01;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import hu.czirko.SpringBoot_01.error.UserNotFoundException;
import hu.czirko.SpringBoot_01.jpa.PersonDaoService;
import hu.czirko.SpringBoot_01.model.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/userjpa")
public class UserJPAResource {
    @Autowired
    private PersonDaoService service;


    @GetMapping(path = "/all")
    public List<Person> retrieveAllUsers() {
        return service.getUsers();
    }

    @GetMapping("/{id}")
    public EntityModel<Person> retrieveUser(@PathVariable int id) {
        Person user = service.findById(id)
                .orElseThrow(() -> new UserNotFoundException("id-" + id));

        EntityModel<Person> resource = EntityModel.of(user);

        WebMvcLinkBuilder linkTo =
                linkTo(methodOn(this.getClass()).retrieveAllUsers());

        resource.add(linkTo.withRel("all-users"));

        //HATEOAS

        return resource;
    }


}
