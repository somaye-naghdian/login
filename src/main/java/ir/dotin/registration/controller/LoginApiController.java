package ir.dotin.registration.controller;

import ir.dotin.registration.controller.dto.LoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class LoginApiController implements  LoginApi{
    @Override
    public ResponseEntity<String> signup(LoginDto loginDto) {
        return null;
    }
}
