package io.github.jvictor12.apialunosposgraduate.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    private Estudante estudante;

    @ManyToOne
    @MapsId("cursoId")
    @JoinColumn(name = "curso_id")
    @JsonBackReference
    private Curso curso;

    private Integer notaDaAvaliacao;
}
