package io.github.jvictor12.apialunosposgraduate.service;

import io.github.jvictor12.apialunosposgraduate.entity.Estudante;
import io.github.jvictor12.apialunosposgraduate.entity.Livro;
import io.github.jvictor12.apialunosposgraduate.infraestrutura.exception.ObjectNotFoundException;
import io.github.jvictor12.apialunosposgraduate.infraestrutura.exception.ValidationException;
import io.github.jvictor12.apialunosposgraduate.repository.EstudanteRepository;
import io.github.jvictor12.apialunosposgraduate.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;
    @Autowired
    private LivroRepository livroRepository;


    public Estudante findById(Long id) {
        return estudanteRepository.findById(id).orElseThrow(()-> {
            throw new ObjectNotFoundException("Estudante não encontrado");
        });
    }

    public List<Estudante> findByAvaliacaoCursoNull(){
        return estudanteRepository.findByAvaliacaoCursoEstudanteIsNull();
    }

    public Page<Estudante> findAll(PageRequest request) {
        return estudanteRepository.findAll(request);
    }

    public Estudante save(Estudante estudante) {
        if (estudante == null){
            throw new ValidationException("Estudante Nulo");
        }
        estudanteRepository.save(estudante);

        return estudante;
    }

    public Estudante update(Estudante estudante) {
        if (estudante == null){
            throw new ValidationException("Estudante Nulo");
        }
        if (!estudanteRepository.existsById(estudante.getId())){
            throw new ObjectNotFoundException("Estudante não cadastrado no sistema");
        }
        if(estudante.getLivros() != null || !estudante.getLivros().isEmpty()){
            for ( Livro livro : estudante.getLivros()) {
                Optional<Livro> livro1 = livroRepository.findById(livro.getId());
                if(!livro.equals(livro1)){
                    if (livro.getTitulo() == null || livro.getTitulo().isEmpty()){
                        livro.setTitulo(livro1.get().getTitulo());
                    }
                }
            }
        }
        estudanteRepository.save(estudante);

        return estudante;
    }

    public void delete(Long id) {
        if (!estudanteRepository.existsById(id)){
            throw new ObjectNotFoundException("Estudante não cadastrado no sistema");
        }
        estudanteRepository.deleteById(id);
    }
}
