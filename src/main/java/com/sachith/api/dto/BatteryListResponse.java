package com.sachith.api.dto;

import com.sachith.api.entity.BatteryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BatteryListResponse {

    private long count;
    private double averageCapacity;
    private List<BatteryEntity> batteryEntityList;
}
