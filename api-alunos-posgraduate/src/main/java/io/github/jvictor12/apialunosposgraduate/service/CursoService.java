package io.github.jvictor12.apialunosposgraduate.service;

import io.github.jvictor12.apialunosposgraduate.entity.Curso;
import io.github.jvictor12.apialunosposgraduate.infraestrutura.exception.ObjectNotFoundException;
import io.github.jvictor12.apialunosposgraduate.infraestrutura.exception.ValidationException;
import io.github.jvictor12.apialunosposgraduate.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    public Curso findById(Long id) {
        return cursoRepository.findById(id).orElseThrow(()-> {
            throw new ObjectNotFoundException("Curso nao encontrado");
        });
    }

    public Curso save(Curso curso) {
        if (curso == null) {
            throw new ValidationException("Curso invalido");
        }

        cursoRepository.save(curso);
        return curso;
    }

    public Curso update(Curso curso) {
        if (curso == null) {
            throw new ValidationException("Curso invalido");
        }
        if (!cursoRepository.existsById(curso.getId())){
            throw new ValidationException("Curso nao cadastrado no sistema");
        }

        cursoRepository.save(curso);
        return curso;
    }

    public void delete(Long id){
        if (!cursoRepository.existsById(id)){
            throw new ValidationException("Curso nao cadastrado no sistema");
        }

        cursoRepository.deleteById(id);
    }
}
