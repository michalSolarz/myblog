package my.blog.auth.controller;

import my.blog.auth.model.User;
import my.blog.auth.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/users")
public class UsersController {

    private UserRepository userRepository;

    public UsersController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("test-user")
    private User createSampleUser() {
        User user = new User();
        user.setUsername("Testowy");
        user.setEmail("testowy@email.pl");
        user.setPassword("123");
        this.userRepository.save(user);
        return user;
    }

}
