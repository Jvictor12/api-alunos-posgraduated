package io.github.jvictor12.apialunosposgraduate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_avaliacaoCurso")
public class AvaliacaoCurso {

    @EmbeddedId
    private AvaliacaoCursoKey id = new AvaliacaoCursoKey();

    @ManyToOne
    @MapsId("estudanteId")
    @JoinColumn(name = "estudante_id")
    private Estudante estudante;

    @ManyToOne
    @MapsId("cursoId")
    @JoinColumn(name = "curso_id")
    private Curso curso;

    private Integer notaDaAvaliacao;
}
