package io.github.jvictor12.apialunosposgraduate.controller;

import io.github.jvictor12.apialunosposgraduate.entity.Livro;
import io.github.jvictor12.apialunosposgraduate.infraestrutura.service.Facade;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private Facade facade;

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(facade.livroFindById(id));
    }

    @GetMapping()
    public ResponseEntity findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(facade.livroFindAll());
    }

    @PostMapping()
    public ResponseEntity save(@RequestBody @Valid Livro livro){
        return ResponseEntity.status(HttpStatus.OK).body(facade.livroSave(livro));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody @Valid Livro livro){
        return ResponseEntity.status(HttpStatus.OK).body(facade.livroUpdate(livro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        facade.livroDelete(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
