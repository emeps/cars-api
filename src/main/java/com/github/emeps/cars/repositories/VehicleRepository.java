package com.github.emeps.cars.repositories;

import com.github.emeps.cars.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
