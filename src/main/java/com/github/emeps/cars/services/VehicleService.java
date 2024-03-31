package com.github.emeps.cars.services;

import com.github.emeps.cars.DTOS.CreateVehicleData;
import com.github.emeps.cars.DTOS.UpdateVehicleData;
import com.github.emeps.cars.models.Vehicle;
import com.github.emeps.cars.pagination.Page;
import com.github.emeps.cars.repositories.ModelRepository;
import com.github.emeps.cars.repositories.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
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
    public Vehicle update(UpdateVehicleData data, Long id) {

        var vehicle = vehicleRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"vehicle not found"));

        var model = modelRepository.findById(data.getModelId())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"model not found"));
        vehicle.setKilometers(data.getKilometers());
        vehicle.setColor(data.getColor());
        vehicle.setDescription(data.getDescription());
        vehicle.setYear(data.getYear());
        vehicle.setModel(model);

        vehicleRepository.save(vehicle);

        return vehicle;

    }

    public Page<Vehicle> list(Pageable pageable) {
        var page =  vehicleRepository.findAll(pageable);
        return  new Page<>(page);
    }
    public Vehicle show(Long id){
        return vehicleRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehicle not found")
        );
    }

    public void deleteById(Long id){
        if (!vehicleRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "vehicle not found");
        }
        vehicleRepository.deleteById(id);
        return;
    }
}
