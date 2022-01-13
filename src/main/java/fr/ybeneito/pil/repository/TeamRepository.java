package fr.ybeneito.pil.repository;

import fr.ybeneito.pil.models.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Integer> {

    /*
    @Query("SELECT Team.name from Team join TeamPerson tp on Team .id = tp.team.id WHERE Person.id = :pid")
    List<Team> findByPersonId(@Param("pid") Integer pid);
    */
}
