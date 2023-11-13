package io.github.jvictor12.apialunosposgraduate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Arquivo {
    private String nome;
    private String linkkDownload;
    private String extensaoArquivo;
    private Long size;
}
