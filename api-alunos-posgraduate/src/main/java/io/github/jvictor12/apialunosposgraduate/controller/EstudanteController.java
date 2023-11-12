package io.github.jvictor12.apialunosposgraduate.controller;

import io.github.jvictor12.apialunosposgraduate.entity.Estudante;
import io.github.jvictor12.apialunosposgraduate.service.EstudanteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudantes")
public class EstudanteController {

    @Autowired
    private EstudanteService estudanteService;

    @GetMapping("/{id}")
    public ResponseEntity<Estudante> buscarEstudanteById(@PathVariable Long id) {
        return estudanteService.buscarEstudanteById(id);
    }

    @GetMapping
    public List<Estudante> buscarEstudantes() {
        return estudanteService.buscarEstudantes();
    }

    @PostMapping
    public ResponseEntity<Estudante> cadastrarEstudante(@RequestBody @Valid Estudante estudante) {
        return estudanteService.cadastrarEstudante(estudante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudante> atualizarEstudante(@RequestBody @Valid Estudante estudante) {
        return estudanteService.atualizarEstudante(estudante);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirEstudante(@PathVariable Long id) {
        return estudanteService.excluirEstudante(id);
    }
}
