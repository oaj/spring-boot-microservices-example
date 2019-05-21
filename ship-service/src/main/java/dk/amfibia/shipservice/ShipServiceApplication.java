package dk.amfibia.shipservice;

import dk.amfibia.shipservice.model.Ship;
import dk.amfibia.shipservice.repository.ShipRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@SpringBootApplication
public class ShipServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShipServiceApplication.class, args);
    }

}

@Component
class ShipCommandLineRunner implements CommandLineRunner {

    private final ShipRepository repository;

    public ShipCommandLineRunner(ShipRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) {
        // Top beers from https://www.beeradvocate.com/lists/us
        Stream.of("Clipper", "Canoe",
                "Laser boat", "Brig", "Super tanker",
                "Container ship", "Coaster", "Barge", "Trump").forEach(name ->
                repository.save(new Ship(name))
        );

        repository.findAll().forEach(System.out::println);
    }
}