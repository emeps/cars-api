package com.github.emeps.cars.controllers;

import com.github.emeps.cars.models.Manufacturer;
import com.github.emeps.cars.models.Model;
import com.github.emeps.cars.models.Vehicle;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    @GetMapping
    public  List<Vehicle> index(){
//        return  List.of(
//                new Vehicle(
//                        1L,
//                        10000,
//                        "Azul",
//                        "Novo",
//                        true,
//                        1987,
//                        new Model(
//                                1L,
//                                "Fusca",
//                                new Manufacturer(
//                                        1L,
//                                        "Volks"
//                                )
//                        )
//                )
//        );
        return  null;
    }

    @GetMapping("/{id}")
    public List<Vehicle> show(@PathVariable("id") Long id){
//        return  List.of(
//                new Vehicle(
//                        1L,
//                        10000,
//                        "Azul",
//                        "Novo",
//                        true,
//                        1987,
//                        new Model(
//                                1L,
//                                "Fusca",
//                                new Manufacturer(
//                                        1L,
//                                        "Volks"
//                                )
//                        )
//                )
//        );
        return null;
    }

    @PostMapping
    public Vehicle create(Vehicle vehicle){
        return null;
    }

    @PutMapping("/{id}")
    public Vehicle update(Vehicle vehicle, @PathVariable("id")Long id){
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(Vehicle vehicle, @PathVariable("id")Long id){
    }
}
