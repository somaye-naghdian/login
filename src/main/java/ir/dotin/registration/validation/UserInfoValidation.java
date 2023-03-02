package ir.dotin.registration.validation;

import ir.dotin.registration.exception.InvalidInputException;

import java.util.Objects;

public class UserInfoValidation {

    public static void validate(String email, String password) {
        Objects.requireNonNull(email, "email is mandatory !");
        Objects.requireNonNull(password, "password is mandatory !");
        if (email.isEmpty() || password.isEmpty()) {
            throw new InvalidInputException();
        }
    }
}
