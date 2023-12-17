//package io.github.jvictor12.apialunosposgraduate.service;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import io.github.jvictor12.apialunosposgraduate.entity.Estudante;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.time.ZoneOffset;
//
//@Service
//public class TokenService {
//    public String gerarToken(Estudante estudante) {
//
//        return JWT.create()
//                .withIssuer("Estudantes")
//                .withSubject(estudante.getLogin())
//                .withClaim("id", estudante.getId())
//                .withExpiresAt(LocalDateTime.now()
//                        .plusMinutes(30)
//                        .toInstant(ZoneOffset.of("-03:00"))
//                ).sign(Algorithm.HMAC256("secreta"));
//    }
//}
