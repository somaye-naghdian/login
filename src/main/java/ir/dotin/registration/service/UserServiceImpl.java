package ir.dotin.registration.service;

import ir.dotin.registration.entity.User;
import ir.dotin.registration.exception.InternalServerErrorException;
import ir.dotin.registration.exception.UserNotFoundException;
import ir.dotin.registration.repository.UserRepository;
import ir.dotin.registration.util.HashUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        String encryptPassword;
        try {
            encryptPassword = HashUtil.encryptPassword(password);
        } catch (NoSuchAlgorithmException e) {
            throw new InternalServerErrorException(e);
        }
        return userRepository.findByEmailAndPassword(email, encryptPassword)
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public User save(String email, String password) {
        final String sha1Password = HashUtil.toSha1(password);
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setEmail(email);
        user.setPassword(sha1Password);
        return userRepository.save(user);
    }
}
