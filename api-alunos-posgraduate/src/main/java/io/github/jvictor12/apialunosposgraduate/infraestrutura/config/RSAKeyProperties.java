package io.github.jvictor12.apialunosposgraduate.infraestrutura.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Getter
@Component
public class RSAKeyProperties {

    @Value("${app.security.rsa.public-key}")
    private RSAPublicKey publicKey;

    @Value("${app.security.rsa.private-key}")
    private RSAPrivateKey privateKey;
}