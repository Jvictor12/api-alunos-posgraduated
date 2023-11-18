package io.github.jvictor12.apialunosposgraduate.repository;

import io.github.jvictor12.apialunosposgraduate.entity.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long> {

    //Testing Native Query JPQL and JPA Query Methods

    @Query(value = "SELECT e.* FROM apialunos.tb_estudante e" +
    "LEFT JOIN apialunos.tb_avaliacao_curso ac ON ac.estudante_id = e.id" +
    "WHERE ac.estudante_id is null", nativeQuery = true)
    List<Estudante> findByAvaliacaoCursoEstudanteIsNullNativeQuery();

    @Query(value = "SELECT e FROM Estudante e " +
    " JOIN AvaliacaoCurso ac " +
    " where ac.estudante.id is null")
    List<Estudante> findByAvaliacaoCursoEstudanteIsNullJPQL();

    List<Estudante> findByAvaliacaoCursoEstudanteIsNull();
}
