package io.github.jvictor12.apialunosposgraduate.controller;

import io.github.jvictor12.apialunosposgraduate.entity.Arquivo;
import io.github.jvictor12.apialunosposgraduate.service.ArquivoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/arquivos")
public class ArquivoController {

    @Autowired
    private ArquivoService arquivoService;

    @PostMapping("/upload")
    public Arquivo uploadArquivo (@RequestParam("file") MultipartFile file){
        String nomeArquivo = arquivoService.salvarArquivo(file);

        String caminhoArquivo = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/arquivos/downloadarquivo")
                .path(nomeArquivo)
                .toUriString();

        return new Arquivo(nomeArquivo, caminhoArquivo, file.getContentType(), file.getSize());
    }

    @GetMapping("/downloadarquivo/{nomeArquivo}")
    public ResponseEntity<Resource> downloadArquivo(@PathVariable String nomeArquivo, HttpServletRequest request){
        Resource resource = arquivoService.carregarArquivo(nomeArquivo);
        String contentType = arquivoService.getContentType(request, resource);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""  + resource.getFilename() + "\"")
                .body(resource);
    }

}
