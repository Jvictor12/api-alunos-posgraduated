package io.github.jvictor12.apialunosposgraduate.service;

import io.github.jvictor12.apialunosposgraduate.entity.Livro;
import io.github.jvictor12.apialunosposgraduate.infraestrutura.exception.ObjectNotFoundException;
import io.github.jvictor12.apialunosposgraduate.infraestrutura.exception.ValidationException;
import io.github.jvictor12.apialunosposgraduate.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Livro findById(Long id) {
        return livroRepository.findById(id).orElseThrow( ()-> {
            throw new ObjectNotFoundException("Livro não encontrado no sistema");
        });
    }

    public List<Livro> findAll() { return livroRepository.findAll(); }

    public Livro save(Livro livro) {
        if(livro == null) {
            throw new ValidationException("Livro invalido/nulo");
        }

        livroRepository.save(livro);

        return livro;
    }

    public Livro update(Livro livro) {
        if(livro == null) {
            throw new ValidationException("Livro invalido/nulo");
        }
        if(!livroRepository.existsById(livro.getId())){
            throw new ValidationException("Livro não cadastrado no sistema");
        }

        livroRepository.save(livro);

        return livro;
    }

    public void delete(Long id) {
        if(!livroRepository.existsById(id)){
            throw new ValidationException("Livro não cadastrado no sistema");
        }

        livroRepository.deleteById(id);
    }
}
