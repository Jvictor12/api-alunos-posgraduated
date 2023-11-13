package io.github.jvictor12.apialunosposgraduate.service;

import io.github.jvictor12.apialunosposgraduate.infraestrutura.config.ArquivoStorageProperties;
import io.github.jvictor12.apialunosposgraduate.infraestrutura.exception.FileNotFoundException;
import io.github.jvictor12.apialunosposgraduate.infraestrutura.exception.UploadArquivoException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
@Slf4j
public class ArquivoService {

    private final Path fileStoreLocation;
    public ArquivoService (ArquivoStorageProperties arquivoStorageProperties) {
        this.fileStoreLocation = Paths.get(arquivoStorageProperties.getUploadDir()).toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStoreLocation);
        } catch (IOException e) {
            throw new UploadArquivoException("Ocorreu um erro ao tentar criar a pasta", e);
        }
    }

    public String salvarArquivo(MultipartFile file) {
        String nomeArquivo = StringUtils.cleanPath(file.getOriginalFilename());

        try {
          if(nomeArquivo.contains("..")) {
              throw new UploadArquivoException("Arquivo invalido");
          }
          Path targetLocation = this.fileStoreLocation.resolve(nomeArquivo);
          Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

          return nomeArquivo;
        } catch (Exception e) {
            throw new UploadArquivoException("Erro ao tentar salvar o arquivo", e);
        }
    }

    public Resource carregarArquivo (String nomeArquivo) {
        try {
            Path filePath = this.fileStoreLocation.resolve(nomeArquivo).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()){
                return resource;
            } else {
                throw new FileNotFoundException("Arquivo não encontrado");
            }
        } catch (Exception e) {
            throw new FileNotFoundException("Arquivo não encontrado");
        }
    }

    public String getContentType (HttpServletRequest request, Resource resource) {
        String contentType = null;

        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (Exception e) {
            log.error("Não foi possivel determinar o tipo de arquivo");
        }

        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return contentType;

    }
}
