package io.github.jvictor12.apialunosposgraduate.repository;

import io.github.jvictor12.apialunosposgraduate.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    Curso findByNome(String nome);
}
