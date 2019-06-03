package nl.roovers.greetingservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingsRepository extends JpaRepository<GreetingMessage, Long> {

}
