package io.github.jvictor12.apialunosposgraduate.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "tb_livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Column (columnDefinition = "TEXT")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "estudante_id")
    @JsonBackReference(value = "estudanteLivros")
    private Estudante estudante;
}
