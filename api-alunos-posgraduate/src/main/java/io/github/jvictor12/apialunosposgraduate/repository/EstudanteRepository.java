package io.github.jvictor12.apialunosposgraduate.repository;

import io.github.jvictor12.apialunosposgraduate.entity.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
}
