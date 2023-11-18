package io.github.jvictor12.apialunosposgraduate.repository;

import io.github.jvictor12.apialunosposgraduate.entity.AvaliacaoCurso;
import io.github.jvictor12.apialunosposgraduate.entity.AvaliacaoCursoKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoCursoRepository extends JpaRepository<AvaliacaoCurso, AvaliacaoCursoKey> {
}
