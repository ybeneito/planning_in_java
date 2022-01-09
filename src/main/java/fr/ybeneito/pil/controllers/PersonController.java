package fr.ybeneito.pil.controllers;


import fr.ybeneito.pil.models.Person;
import fr.ybeneito.pil.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("person")
public class PersonController {
    @Autowired
    private PersonRepository repo;


    @PostMapping("add")
    public String addForm(@ModelAttribute Person person, Model m) {
        m.addAttribute("person", person);
        repo.save(person);
        return "person/ok";
    }

    @GetMapping("add")
    public String addForm(Model m) {
        m.addAttribute("person", new Person());
        return "person/addPerson";
    }
    /*
    @PostMapping("/add")
    String addPerson(@RequestParam String username, @RequestParam String description) {
        Person p = new Person();
        p.setUsername(username);
        p.setDescription(description);
        repo.save(p);
        return  "ok";
    }

     */

    @GetMapping("")
    String getAll(Model model) {
        model.addAttribute("persons", repo.findAll());
        return "person/index";
    }
}
