package io.github.jvictor12.apialunosposgraduate.infraestrutura.service;

import io.github.jvictor12.apialunosposgraduate.entity.Curso;
import io.github.jvictor12.apialunosposgraduate.entity.Estudante;
import io.github.jvictor12.apialunosposgraduate.entity.Livro;
import io.github.jvictor12.apialunosposgraduate.service.ArquivoService;
import io.github.jvictor12.apialunosposgraduate.service.CursoService;
import io.github.jvictor12.apialunosposgraduate.service.EstudanteService;
import io.github.jvictor12.apialunosposgraduate.service.LivroService;
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
    private LivroService livroService;

    @Autowired
    private ArquivoService arquivoService;

    @Autowired
    private CursoService cursoService;

    ////////////////////////////////////// ESTUDANTE //////////////////////////////////////////////
    public Page<Estudante> estudanteFindAll(PageRequest request) { return  estudanteService.findAll(request); };

    public Estudante estudanteFindById(Long id ) { return estudanteService.findById(id); };

    public Estudante estudanteSave(Estudante estudante) { return estudanteService.save(estudante); };

    public Estudante estudanteUpdate(Estudante estudante) { return estudanteService.update(estudante); };

    public void estudanteDelete (Long id) { estudanteService.delete(id); };

    ////////////////////////////////////// LIVRO //////////////////////////////////////////////

    public Livro livroFindById(Long id) { return livroService.findById(id); }

    public List<Livro> livroFindAll() { return livroService.findAll(); }

    public Livro livroSave(Livro livro) { return livroService.save(livro); }

    public Livro livroUpdate(Livro livro) { return livroService.update(livro); }

    public void livroDelete(Long id) { livroService.delete(id); }

    ////////////////////////////////////// CURSO //////////////////////////////////////////////

    public List<Curso> cursoFindAll() { return cursoService.findAll(); }

    public Curso cursoFindById(Long id) { return cursoService.findById(id); }

    public Curso cursoFindByNome(String nome) { return cursoService.findByNome(nome); }

    public Curso cursoSave(Curso curso) { return cursoService.save(curso); }

    public Curso cursoUpdate(Curso curso) { return cursoService.update(curso); }

    public void cursoDelete(Long id) { cursoService.delete(id); }
}
