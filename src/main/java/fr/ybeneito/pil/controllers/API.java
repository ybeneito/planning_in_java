package fr.ybeneito.pil.controllers;

import fr.ybeneito.pil.models.User;
import fr.ybeneito.pil.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class API {
    private UserRepository userRepository;

    public API(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @GetMapping("users")
    public List<User> allUsers() {
        return this.userRepository.findAll();
    }

}
