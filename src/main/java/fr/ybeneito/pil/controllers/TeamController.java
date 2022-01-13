package fr.ybeneito.pil.controllers;

import fr.ybeneito.pil.models.Team;
import fr.ybeneito.pil.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("team")
public class TeamController {
    @Autowired
    private TeamRepository repo;


    @GetMapping("")
    String getAll(Model model) {
        model.addAttribute("teams", repo.findAll());
        return "team/index";
    }

    @GetMapping("add")
    public String addForm(Model m) {
        m.addAttribute("team", new Team());
        return "team/addTeam";
    }

    @PostMapping("add")
    public String addForm(@ModelAttribute Team t, Model m) {
        repo.save(t);
        m.addAttribute("teams", repo.findAll());
        return "team/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable(value = "id") Integer id, Model model) {
        Team team = repo.findById(id).orElseThrow();
        repo.delete(team);
        model.addAttribute("teams", repo.findAll());
        return "team/index";
    }
}
