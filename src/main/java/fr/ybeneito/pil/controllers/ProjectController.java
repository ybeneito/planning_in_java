package fr.ybeneito.pil.controllers;

import fr.ybeneito.pil.models.Person;
import fr.ybeneito.pil.models.Project;
import fr.ybeneito.pil.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("project")
public class ProjectController {
    @Autowired
    private ProjectRepository repo;


    @GetMapping("")
    String getAll(Model model) {
        model.addAttribute("projects", repo.findAll());
        return "project/index";
    }

    @GetMapping("add")
    public String addForm(Model m) {
        m.addAttribute("project", new Project());
        return "project/addProject";
    }

    @PostMapping("add")
    public String addForm(@ModelAttribute Project p, Model m) {
        m.addAttribute("project", p);
        repo.save(p);
        return "project/ok";
    }

}
