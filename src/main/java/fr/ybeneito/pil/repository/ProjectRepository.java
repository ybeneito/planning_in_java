package fr.ybeneito.pil.repository;

import fr.ybeneito.pil.models.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Integer> {
}
