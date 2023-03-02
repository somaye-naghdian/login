package ir.dotin.registration.service;

import ir.dotin.registration.entity.User;

public interface UserService {

    User findUserByEmailAndPassword(String email, String password);
    User findUserByEmail(String email);

    User save(String email, String password);
}
