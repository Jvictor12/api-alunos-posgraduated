package io.github.jvictor12.apialunosposgraduate.repository;

import io.github.jvictor12.apialunosposgraduate.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    Optional<Curso> findByNome(String nome);
}
