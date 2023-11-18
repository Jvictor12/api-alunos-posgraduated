package io.github.jvictor12.apialunosposgraduate.controller;

import io.github.jvictor12.apialunosposgraduate.infraestrutura.service.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoCursoController {

    @Autowired
    private Facade facade;

    @PostMapping
    public ResponseEntity avaliar(@RequestParam Long idEstudante, @RequestParam String nomeCurso, @RequestParam Integer notaAvaliacao){
        return ResponseEntity.status(HttpStatus.OK).body(facade.avaliacaoCursoAvaliar(idEstudante, nomeCurso, notaAvaliacao));
    }
}
