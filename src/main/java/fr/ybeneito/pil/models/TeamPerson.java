package fr.ybeneito.pil.models;

import javax.persistence.*;

@Entity
@Table(name = "team_person")
public class TeamPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Team team;

    @ManyToOne
    private Person person;

    public TeamPerson() {}

    public TeamPerson(Team team, Person person) {
        super();
        this.team = team;
        this.person = person;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
