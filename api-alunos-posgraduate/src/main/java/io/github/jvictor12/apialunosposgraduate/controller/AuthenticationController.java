package io.github.jvictor12.apialunosposgraduate.controller;

import io.github.jvictor12.apialunosposgraduate.dto.Login;
import io.github.jvictor12.apialunosposgraduate.utils.JWTTokenUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JWTTokenUtils jwtTokenUtil;

    public AuthenticationController(AuthenticationManager authenticationManager, JWTTokenUtils jwtTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("/login")
    @ResponseStatus(OK)
    HashMap<String, Object> login (@RequestBody Login login) {
        UsernamePasswordAuthenticationToken userName =
                new UsernamePasswordAuthenticationToken(login.login(),
                        login.senha());

        Authentication authenticate = this.authenticationManager.authenticate(userName);
        final var responseBody = new HashMap<String, Object>();
        var token = jwtTokenUtil.generateToken(authenticate);

        responseBody.put("access_token", token);

        return responseBody;
    }
}
