package com.github.emeps.cars.DTOS;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateVehicleData {
    @Min(value = 0)
    @NotNull
    private Integer kilometers;

    @NotEmpty
    private String color ;

    @NotEmpty
    private String description;

    @NotNull
    private Integer year;

    @NotNull
    private Long modelId;
}
