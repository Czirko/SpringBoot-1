package hu.czirko.SpringBoot_01;


import hu.czirko.SpringBoot_01.error.UserNotFoundException;
import hu.czirko.SpringBoot_01.jpa.PersonDaoService;
import hu.czirko.SpringBoot_01.model.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
/*
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserRecource {
    @Autowired
    private PersonDaoService pService;

    @GetMapping(path = "/getAllUser")
    public List<Person> getAllUser() {
        return pService.getUsers();
    }

    @PostMapping("/addUser")
    public ResponseEntity<Person> addUser(@Valid @RequestBody Person p ){
        System.out.println(p);
        Person saved= pService.addUser(p);
        URI loc = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId()).toUri();

        return ResponseEntity.created(loc).build();

    }

    @GetMapping(path = "/getById/{id}")
    public Person getById(@PathVariable int id) {
        return pService.findById(id).orElseThrow(()->new UserNotFoundException("id-"+id));

    }

    @DeleteMapping(path = "/deleteById/{id}")
    public void deleteById(@PathVariable int id) {
        pService.deleteById(id);

    }

}*/
