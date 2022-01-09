package fr.ybeneito.pil.utils;

import fr.ybeneito.pil.models.User;
import fr.ybeneito.pil.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class Dbinit implements CommandLineRunner {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public Dbinit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        this.userRepository.deleteAll();

        User waz = new User("waz", passwordEncoder.encode("123456"), "USER", "");
        User admin = new User("admin", passwordEncoder.encode("nimda"), "ADMIN", "");
        User manager = new User("manager", passwordEncoder.encode("manager"), "MANAGER", "");

        List<User> users = Arrays.asList(waz, admin, manager);

        this.userRepository.saveAll(users);
    }
}
