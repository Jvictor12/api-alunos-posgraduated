package io.github.jvictor12.apialunosposgraduate.infraestrutura.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EstudanteSchedule {

    @Scheduled(cron = "0 0 12 * * *")
    private void mostrarSchedule(){
        log.info("Tarefa executada");
    }
}
