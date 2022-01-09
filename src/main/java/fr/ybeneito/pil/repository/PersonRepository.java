package fr.ybeneito.pil.repository;

import fr.ybeneito.pil.models.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository  extends CrudRepository<Person, Integer> {
}
