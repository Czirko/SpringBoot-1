package hu.czirko.SpringBoot_01.jpa;


import hu.czirko.SpringBoot_01.error.UserNotFoundException;
import hu.czirko.SpringBoot_01.model.domain.Person;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonDaoService {
    private static List<Person> users = new ArrayList<>();


    static {
        users.add(new Person(1, "Sanyi", LocalDate.of(2020, 5, 30)));
        users.add(new Person(2, "Marcsi", LocalDate.of(1568, 5, 13)));
        users.add(new Person(3, "Luszivagyok97", LocalDate.of(1854, 9, 24)));
    }

    public List<Person> getUsers() {
        return users;
    }

    public Person addUser(Person p) {

        if (p.getId() == null)
            p.setId(users.size() + 1);
        users.add(p);
        return p;
    }

    public Optional<Person> findById(int id) {
        return users.stream()
                .filter(p -> p.getId() == id)
                .findFirst();

    }

    public void deleteById(int id) {

        users.remove(users.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("Id-" + id)));
    }

}
