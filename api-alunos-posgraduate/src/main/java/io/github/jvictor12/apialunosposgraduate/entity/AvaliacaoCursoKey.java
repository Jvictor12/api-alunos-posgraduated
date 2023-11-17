package io.github.jvictor12.apialunosposgraduate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class AvaliacaoCursoKey implements Serializable {

    private static final Long serialVersionUID = 1l;

    @Column(name = "estudante_id")
    private Long estudanteId;

    @Column(name = "curso_id")
    private Long cursoId;
}
