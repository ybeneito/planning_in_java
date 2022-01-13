package fr.ybeneito.pil.controllers;

import fr.ybeneito.pil.models.Person;
import fr.ybeneito.pil.models.Project;
import fr.ybeneito.pil.models.Team;
import fr.ybeneito.pil.repository.ProjectRepository;
import fr.ybeneito.pil.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("project")
public class ProjectController {
    @Autowired
    private ProjectRepository repo;

    @Autowired
    private TeamRepository Trepo;


    @GetMapping("")
    String getAll(Model model) {
        model.addAttribute("projects", repo.findAll());
        return "project/index";
    }

    @GetMapping("add")
    public String addForm(Model m) {

        List<Team> tList = (List<Team>) Trepo.findAll();
        m.addAttribute("project", new Project());
        m.addAttribute("tList", tList);
        return "project/addProject";
    }

    @PostMapping("add")
    public String addForm(@ModelAttribute Project p, Model m) {
        repo.save(p);
        m.addAttribute("projects", repo.findAll());
        return "project/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable(value = "id") Integer id, Model model) {
        Project project = repo.findById(id).orElseThrow();
        repo.delete(project);
        model.addAttribute("projects", repo.findAll());
        return "project/index";
    }

}
