package com.sachith.api.controller;

import com.sachith.api.dto.BatteryDTO;
import com.sachith.api.entity.BatteryEntity;
import com.sachith.api.service.BatteryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/battery")
@RequiredArgsConstructor
public class BatteryController {

    private final BatteryService batteryService;

    @PostMapping
    ResponseEntity<List<BatteryEntity>> addBatteries(@RequestBody @Valid List<BatteryDTO> batteryDTOList) {

        List<BatteryEntity> batteryEntities = batteryDTOList.stream()
                .map(dto -> new BatteryEntity(1L, dto.getName(), dto.getPostcode(), dto.getCapacity()))
                .collect(Collectors.toList());

        List<BatteryEntity> createdBatteries = batteryService.saveBattery(batteryEntities);

        if (createdBatteries == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(createdBatteries);
    }

    @GetMapping("/{postcode1}/{postcode2}")
    public ResponseEntity<List<BatteryEntity>> getBatteriesByPostalCode(
            @PathVariable("postcode1") @Min(4) @Max(4) Integer fromPostCode,
            @PathVariable("postcode2") @Min(4) @Max(4) Integer toPostCode
    ) {
        return ResponseEntity.ok(batteryService.getBatteriesByPostalCode(fromPostCode.toString(), toPostCode.toString()));
    }
}
