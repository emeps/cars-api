package com.github.emeps.cars.controllers;

import com.github.emeps.cars.DTOS.CreateVehicleData;
import com.github.emeps.cars.DTOS.VehicleDetailsData;
import com.github.emeps.cars.DTOS.UpdateVehicleData;
import com.github.emeps.cars.pagination.Page;
import com.github.emeps.cars.services.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicles")
@AllArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;
    @GetMapping
    public Page<VehicleDetailsData> index(Pageable pageable){
        var page = vehicleService.list(pageable);
        return page.map(VehicleDetailsData::new);
    }

    @GetMapping("/show/{id}")
    public VehicleDetailsData show(@PathVariable("id") Long id){
        return new VehicleDetailsData(vehicleService.show(id));
    }

    @PostMapping("/create")
    public VehicleDetailsData create(@RequestBody @Validated CreateVehicleData data ){
        return new VehicleDetailsData(vehicleService.create(data));
    }

    @PutMapping("/update/{id}")
    public VehicleDetailsData update(@RequestBody @Validated UpdateVehicleData vehicle, @PathVariable("id")Long id){
        return new VehicleDetailsData(vehicleService.update(
                vehicle, id));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id")Long id){
        vehicleService.deleteById(id);
    }
}
