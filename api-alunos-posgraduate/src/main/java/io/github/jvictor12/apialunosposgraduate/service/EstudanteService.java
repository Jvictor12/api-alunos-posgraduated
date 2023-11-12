package io.github.jvictor12.apialunosposgraduate.service;

import io.github.jvictor12.apialunosposgraduate.entity.Estudante;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EstudanteService {

    private static Map<Long, Estudante> listaEstudante = new HashMap<>();

    public ResponseEntity<Estudante> buscarEstudanteById(Long id) {
        Estudante estudante = listaEstudante.get(id);
        if(estudante != null){
            return ResponseEntity.status(HttpStatus.OK).body(estudante);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    public List<Estudante> buscarEstudantes() {
        return new ArrayList<>(listaEstudante.values());

    }

    public ResponseEntity<Estudante> cadastrarEstudante(Estudante estudante) {
        Estudante estudanteEncontrado = listaEstudante.get(estudante.getId());
        if (estudanteEncontrado == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(estudante);
    }

    public ResponseEntity<Estudante> atualizarEstudante(Estudante estudante) {
        Estudante estudanteEncontrado = listaEstudante.get(estudante.getId());
        if (estudanteEncontrado == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        listaEstudante.put(estudante.getId(), estudante);
        return ResponseEntity.status(HttpStatus.OK).body(estudante);
    }

    public ResponseEntity<String> excluirEstudante(Long id) {
        Estudante estudanteEncontrado = listaEstudante.get(id);
        if (estudanteEncontrado == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        listaEstudante.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deletado");
    }
}
