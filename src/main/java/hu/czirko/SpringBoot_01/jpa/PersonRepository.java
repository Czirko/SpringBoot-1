package hu.czirko.SpringBoot_01.jpa;

import hu.czirko.SpringBoot_01.model.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {
}
