package io.github.jvictor12.apialunosposgraduate.controller;

import io.github.jvictor12.apialunosposgraduate.entity.Curso;
import io.github.jvictor12.apialunosposgraduate.infraestrutura.service.Facade;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private Facade facade;


    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(facade.cursoFindAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(facade.cursoFindById(id));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid Curso curso) {
        return ResponseEntity.status(HttpStatus.OK).body(facade.cursoSave(curso));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody @Valid Curso curso) {
        return ResponseEntity.status(HttpStatus.OK).body(facade.cursoUpdate(curso));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id) {
        facade.cursoDelete(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
