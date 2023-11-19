package io.github.jvictor12.apialunosposgraduate.controller;

import io.github.jvictor12.apialunosposgraduate.infraestrutura.service.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/async")
public class AsyncController {

    @Autowired
    private Facade facade;

    @GetMapping
    public ResponseEntity gerarRelatorio() throws InterruptedException {
        facade.asynGerarRelatorio();
        return ResponseEntity.status(HttpStatus.OK).body("Tarefa iniciada");
    }
}
