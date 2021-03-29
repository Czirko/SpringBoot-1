package hu.czirko.SpringBoot_01.jpa;


import hu.czirko.SpringBoot_01.error.UserNotFoundException;
import hu.czirko.SpringBoot_01.model.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonDaoService {
    @Autowired
    private PersonRepository personRepo;


    public List<Person> findAll() {
        return personRepo.findAll();
    }

    public Person addUser(Person p) {

     return personRepo.save(p);

    }

    public Optional<Person> findById(int id) {
        return personRepo
                .findById(id);
    }

    public void deleteById(int id) {
        personRepo
                .delete(personRepo
                        .findById(id)
                        .orElseThrow(
                                ()-> new UserNotFoundException("There is No User with Id-"+id)));
    }

}
