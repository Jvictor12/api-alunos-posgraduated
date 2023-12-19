package io.github.jvictor12.apialunosposgraduate.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_avaliacaoCurso")
public class AvaliacaoCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estudante_id")
    @JsonBackReference(value = "estudanteAvaliacaoCurso")
    private Estudante estudante;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    @JsonBackReference(value = "cursoAvaliacaoCurso")
    private Curso curso;

    private Integer notaDaAvaliacao;
}
