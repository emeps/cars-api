package com.github.emeps.cars.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "kilometers")
    private  Integer kilometers;
    @Column(name = "color", length = 155)
    private String color;
    @Column(name = "description", length = 250)
    private String description;
    @Column(name = "available")
    private Boolean available;
    @Column(name = "year")
    private Integer year;

    @JoinColumn(name = "model_id")
    @ManyToOne
    private Model model;

    @JoinTable(
            name = "vehicle_optional",
            joinColumns = {@JoinColumn(name = "vehicle_id")},
            inverseJoinColumns = {@JoinColumn(name = "optional_id")}
    )
    @ManyToMany
    private List<Optional> optionals;

}
