package nl.roovers.greetingservice;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@RequiredArgsConstructor
public class GreetingserviceApplication {

    private final GreetingsRepository repo;

//    @Value(value = "${greeting.hello:Hello Wereld!}")
//    private String message;
    @GetMapping
    public String greetingGet() {
        return repo.findAll().get(0).getMessage();
    }

    public static void main(String[] args) {
        SpringApplication.run(GreetingserviceApplication.class, args);
    }

    @Bean
    public CommandLineRunner initDB(GreetingsRepository repo) {
        return (args) -> {
            repo.save(new GreetingMessage(null, "Hello, from DB"));
        };
    }
}
