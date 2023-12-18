package io.github.jvictor12.apialunosposgraduate.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import io.github.jvictor12.apialunosposgraduate.dto.Login;
import io.github.jvictor12.apialunosposgraduate.utils.JWTTokenUtils;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
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

    @PostMapping("/token")
    @ResponseStatus(OK)
    @Operation(summary = "Token", description = "Generate an authentication token")
    HashMap<String, Object> token(@RequestBody ObjectNode object) {

        final var username = object.get("username").asText();
        final var password = object.get("password").asText();
        final var authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password, Collections.emptyList()));
        final var responseBody = new HashMap<String, Object>();
        final var token = jwtTokenUtil.generateToken(authentication);

        responseBody.put("access_token", token);

        return responseBody;
    }
}
