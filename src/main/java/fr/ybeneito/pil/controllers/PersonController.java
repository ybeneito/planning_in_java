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
        repo.save(person);
        m.addAttribute("persons", repo.findAll());
        return "person/index";
    }

    @GetMapping("add")
    public String addForm(Model m) {
        m.addAttribute("person", new Person());
        return "person/addPerson";
    }

    @GetMapping("")
    String getAll(Model model) {
        model.addAttribute("persons", repo.findAll());
        return "person/index";
    }

    @GetMapping("{id}")
    String getOne(@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("person", repo.findById(id).get());
        return "person/personDetails";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable(value = "id") Integer id, Model model) {
        Person person = repo.findById(id).orElseThrow();
        repo.delete(person);
        model.addAttribute("persons", repo.findAll());
        return "person/index";
    }

}
