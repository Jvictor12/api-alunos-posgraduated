package io.github.jvictor12.apialunosposgraduate.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Estudante {

    private Long id;
    private String nome;
    private String email;
    private LocalDate dataNascimento;
}
