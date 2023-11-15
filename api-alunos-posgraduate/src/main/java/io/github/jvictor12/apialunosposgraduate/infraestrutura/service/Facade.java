package io.github.jvictor12.apialunosposgraduate.infraestrutura.service;

import io.github.jvictor12.apialunosposgraduate.entity.Estudante;
import io.github.jvictor12.apialunosposgraduate.service.ArquivoService;
import io.github.jvictor12.apialunosposgraduate.service.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Facade {

    @Autowired
    private EstudanteService estudanteService;

    @Autowired
    private ArquivoService arquivoService;

    public Page<Estudante> estudanteFindAll(PageRequest request) { return  estudanteService.findAll(request); };

    public Estudante estudanteFindById(Long id ) { return estudanteService.findById(id); };

    public Estudante estudanteSave(Estudante estudante) { return estudanteService.save(estudante); };

    public Estudante estudanteUpdate(Estudante estudante) { return estudanteService.update(estudante); };

    public void estudanteDelete (Long id) { estudanteService.delete(id); };
}