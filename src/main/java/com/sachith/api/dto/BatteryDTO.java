package com.sachith.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@Builder
public class BatteryDTO {

    @NotNull(message = "Battery name cannot be null")
    @NotBlank(message = "Battery name cannot be empty")
    private String name;

    @Length(min = 4, max = 4, message = "Length should be 4")
    private String postcode;

    private Integer capacity;
}
