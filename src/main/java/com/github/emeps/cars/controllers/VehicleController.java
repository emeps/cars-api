package com.github.emeps.cars.controllers;

import com.github.emeps.cars.DTOS.CreateVehicleData;
import com.github.emeps.cars.models.Vehicle;
import com.github.emeps.cars.services.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
@AllArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;
    @GetMapping
    public  List<Vehicle> index(){
        return  vehicleService.list();
    }

    @GetMapping("/{id}")
    public Vehicle show(@PathVariable("id") Long id){
        return vehicleService.show(id);
    }

    @PostMapping("/create")
    public Vehicle create(@RequestBody CreateVehicleData data ){
        return vehicleService.create(data);
    }

    @PutMapping("/{id}")
    public Vehicle update(Vehicle vehicle, @PathVariable("id")Long id){
        return vehicleService.update(vehicle, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Long id){
        vehicleService.deleteById(id);
    }
}
