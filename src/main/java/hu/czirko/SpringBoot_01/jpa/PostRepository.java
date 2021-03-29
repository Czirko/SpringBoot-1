package hu.czirko.SpringBoot_01.jpa;

import hu.czirko.SpringBoot_01.model.domain.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Integer> {
}
