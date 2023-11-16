package io.github.jvictor12.apialunosposgraduate.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "tb_livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Column (columnDefinition = "TEXT")
    private String descricao;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "estudante_id", nullable = false)
    private Estudante estudante;
}
