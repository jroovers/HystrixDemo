package nl.roovers.greetingclient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.net.URI;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GreetingsService {

    private final RestTemplate restTemplate;

    public GreetingsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "defaultFallback")
    public String greetings() {
        URI url = URI.create("http://localhost:8080/");
        return restTemplate.getForObject(url, String.class);
    }

    public String defaultFallback() {
        return "Hello van Client!!";
    }

}
