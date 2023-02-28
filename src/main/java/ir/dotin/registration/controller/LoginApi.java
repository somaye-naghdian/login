package ir.dotin.registration.controller;

import ir.dotin.registration.controller.dto.LoginDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public interface LoginApi {

    @PostMapping("/login")
    @CrossOrigin("*")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<String> signup(@Valid @RequestBody LoginDto loginDto);
}
