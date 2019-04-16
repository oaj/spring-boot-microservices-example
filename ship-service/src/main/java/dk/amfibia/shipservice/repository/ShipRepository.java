package dk.amfibia.shipservice.repository;

import dk.amfibia.shipservice.model.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public @RepositoryRestResource
interface ShipRepository extends JpaRepository<Ship, Long> {
}

