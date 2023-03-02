package ir.dotin.registration.controller;

import ir.dotin.registration.controller.dto.LoginDto;
import ir.dotin.registration.controller.dto.SuccessfulResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("")
public interface LoginApi {

    @PostMapping("/login")
    @CrossOrigin("*")
    @ResponseStatus(HttpStatus.OK)
    SuccessfulResponse signup(@Valid @RequestBody LoginDto loginDto);
}
