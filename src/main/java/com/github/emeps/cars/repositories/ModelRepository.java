package com.github.emeps.cars.repositories;

import com.github.emeps.cars.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {

}
