package io.github.jvictor12.apialunosposgraduate.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AsyncService {

    @Async
    public void gerarRelatorio() throws InterruptedException {
        log.info("Tarefa iniciada com sucesso");
        Thread.sleep(5000);

        log.info("Tarefa finalizada");
    }
}
