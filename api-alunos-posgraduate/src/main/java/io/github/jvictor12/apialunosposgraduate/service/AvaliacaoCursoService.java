package io.github.jvictor12.apialunosposgraduate.service;


import io.github.jvictor12.apialunosposgraduate.entity.AvaliacaoCurso;
import io.github.jvictor12.apialunosposgraduate.entity.Curso;
import io.github.jvictor12.apialunosposgraduate.entity.Estudante;
import io.github.jvictor12.apialunosposgraduate.infraestrutura.exception.ValidationException;
import io.github.jvictor12.apialunosposgraduate.repository.AvaliacaoCursoRepository;
import io.github.jvictor12.apialunosposgraduate.repository.CursoRepository;
import io.github.jvictor12.apialunosposgraduate.repository.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AvaliacaoCursoService {

    @Autowired
    private AvaliacaoCursoRepository avaliacaoCursoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private EstudanteRepository estudanteRepository;

    public String avaliar(Long idEstudante, String nomeCurso, Integer notaAvaliacao){

        Optional<Estudante> estudanteOptional = estudanteRepository.findById(idEstudante);

        if (!estudanteRepository.existsById(idEstudante)){
            throw new ValidationException("Estudante não encontrado");
        }

        Optional<Curso> cursoOptional = cursoRepository.findByNome(nomeCurso);
        if (!cursoOptional.isPresent()){
            throw new ValidationException("Curso nao encontrado");
        }

        AvaliacaoCurso avaliacaoCurso = new AvaliacaoCurso();

        avaliacaoCurso.setEstudante(estudanteOptional.get());
        avaliacaoCurso.setCurso(cursoOptional.get());
        avaliacaoCurso.setNotaDaAvaliacao(notaAvaliacao);

        avaliacaoCursoRepository.save(avaliacaoCurso);

        return "Avalicao salva com sucesso!";
    }
}
