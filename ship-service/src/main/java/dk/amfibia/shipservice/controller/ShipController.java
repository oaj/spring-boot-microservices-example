package dk.amfibia.shipservice.controller;

import dk.amfibia.shipservice.model.Ship;
import dk.amfibia.shipservice.repository.ShipRepository;
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
    public Collection<Ship> goodShips() {

        return repository.findAll().stream()
                .filter(this::isGreat)
                .collect(Collectors.toList());
    }

    private boolean isGreat(Ship ship) {
        return ship.getName().equals("Clipper") ||
                ship.getName().equals("Brig") ||
                ship.getName().equals("Barge");
    }
}