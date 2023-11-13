package io.github.jvictor12.apialunosposgraduate.infraestrutura.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ArquivoStorageProperties {

    @Value("${arquivo.uploadDir}")
    private String uploadDir;
}
