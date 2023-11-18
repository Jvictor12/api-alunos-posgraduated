package io.github.jvictor12.apialunosposgraduate.controller;

import io.github.jvictor12.apialunosposgraduate.entity.Estudante;
import io.github.jvictor12.apialunosposgraduate.infraestrutura.service.Facade;
import io.github.jvictor12.apialunosposgraduate.service.EstudanteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudantes")
public class EstudanteController {

    @Autowired
    private Facade facade;

    @GetMapping("/{id}")
    public ResponseEntity buscarEstudanteById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(facade.estudanteFindById(id));
    }

    @GetMapping("/avaliacaonull")
    public ResponseEntity buscarEstudanteSemAvaliacao(){
        return ResponseEntity.status(HttpStatus.OK).body(facade.estudantesFindByAvaliacaoCursoEstudanteIsNull());
    }

    @GetMapping
    public ResponseEntity buscarEstudantes(@RequestParam(defaultValue = "0") Integer pagina, @RequestParam(defaultValue = "5") Integer itensPorPagina) {
        return ResponseEntity.status(HttpStatus.OK).body(facade.estudanteFindAll(PageRequest.of(pagina, itensPorPagina)));
    }

    @PostMapping
    public ResponseEntity cadastrarEstudante(@RequestBody @Valid Estudante estudante) {
        return ResponseEntity.status(HttpStatus.OK).body(facade.estudanteSave(estudante));
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizarEstudante(@RequestBody @Valid Estudante estudante) {
        return ResponseEntity.status(HttpStatus.OK).body(facade.estudanteUpdate(estudante));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirEstudante(@PathVariable Long id) {
        facade.estudanteDelete(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
