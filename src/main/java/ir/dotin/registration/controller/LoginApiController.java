package ir.dotin.registration.controller;

import ir.dotin.registration.controller.dto.LoginDto;
import ir.dotin.registration.controller.dto.SuccessfulResponse;
import ir.dotin.registration.entity.User;
import ir.dotin.registration.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class LoginApiController implements LoginApi {

    private final UserService userService;

    @Override
    public SuccessfulResponse signup(LoginDto loginDto) {
        final User user = userService.findUserByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword());
        return SuccessfulResponse.builder()
                .code(200)
                .message("successful with id " + user.getId())
                .build();
    }
}
