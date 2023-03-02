package ir.dotin.registration.config;

import ir.dotin.registration.exception.UserNotFoundException;
import ir.dotin.registration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class UserCreator {

    @Autowired
    private UserService userService;

    @PostConstruct
    public void init() {
        String email = "somayeh@gmail.com";
        String password = "somayeh12345";
        try {
            userService.findUserByEmail(email);
        } catch (UserNotFoundException e) {
            userService.save(email, password);
        }
    }
}
