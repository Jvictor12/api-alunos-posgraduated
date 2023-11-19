package io.github.jvictor12.apialunosposgraduate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableScheduling
@SpringBootApplication
@EnableAsync
public class ApiAlunosPosgraduateApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiAlunosPosgraduateApplication.class, args);
	}
}
