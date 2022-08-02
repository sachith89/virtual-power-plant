package com.sachith.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class BatteryDTO {

    private String name;
    private Integer postcode;
    private Integer capacity;
}
