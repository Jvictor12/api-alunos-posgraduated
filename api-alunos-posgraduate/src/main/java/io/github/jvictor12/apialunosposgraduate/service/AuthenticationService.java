package io.github.jvictor12.apialunosposgraduate.service;

import io.github.jvictor12.apialunosposgraduate.repository.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private EstudanteRepository estudanteRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final var estudante = estudanteRepository.findByLogin(username);

        if(estudante != null) {
            return estudante;
        }
        throw new UsernameNotFoundException("Usuario nao encontrado e/ou senha invalida");
    }
}
