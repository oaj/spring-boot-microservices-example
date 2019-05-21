package dk.amfibia.shipservice.controller;

import dk.amfibia.shipservice.model.Ship;
import dk.amfibia.shipservice.repository.ShipRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class ShipController {

    private ShipRepository repository;

    public ShipController(ShipRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/good-ships")
    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5000"})
    public Collection<Ship> goodShips() {
        System.out.println("goodShips !");
        return repository.findAll().stream()
                .filter(this::isGreat)
                .collect(Collectors.toList());
    }

    private boolean isGreat(Ship ship) {
        return ship.getName().equals("Clipper") ||
                ship.getName().equals("Brig") ||
                ship.getName().equals("Trump") ||
                ship.getName().equals("Barge");
    }
}