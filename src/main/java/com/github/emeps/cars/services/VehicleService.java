package com.github.emeps.cars.services;

import com.github.emeps.cars.DTOS.CreateVehicleData;
import com.github.emeps.cars.models.Vehicle;
import com.github.emeps.cars.repositories.ModelRepository;
import com.github.emeps.cars.repositories.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final ModelRepository modelRepository;

    public Vehicle create(CreateVehicleData data) {

        var model = modelRepository.findById(data.getModelId())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"model not found"));

        var vehicle = new Vehicle(
                data.getKilometers(),
                data.getColor(),
                data.getDescription(),
                data.getYear(),
                model
        );
        vehicleRepository.save(vehicle);

        return vehicle;
    }
    public Vehicle update(Vehicle vehicle, Long id) {
        return null;
    }

    public List<Vehicle> list() {
        return  vehicleRepository.findAll();
    }
    public Vehicle show(Long id){
        return vehicleRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehicle not found")
        );
    }

    public void deleteById(Long id){
        vehicleRepository.deleteById(id);
    }


}
