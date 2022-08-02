package com.sachith.api.controller;

import com.sachith.api.dto.BatteryDTO;
import com.sachith.api.dto.BatteryListResponse;
import com.sachith.api.entity.BatteryEntity;
import com.sachith.api.service.BatteryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/battery")
@RequiredArgsConstructor
@Validated
public class BatteryController {

    private final BatteryService batteryService;

    @PostMapping
    @NotEmpty(message = "Input battery list cannot be empty.")
    ResponseEntity<List<BatteryEntity>> addBatteries(@RequestBody List<@Valid BatteryDTO> batteryDTOList) {

        List<BatteryEntity> batteryEntityList = batteryDTOList.stream()
                .map(dto -> BatteryEntity.builder().name(dto.getName()).postcode(dto.getPostcode()).capacity(dto.getCapacity()).build())
                .collect(Collectors.toList());

        List<BatteryEntity> createdBatteries = batteryService.saveBattery(batteryEntityList);

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

    @GetMapping
    public ResponseEntity<BatteryListResponse> getAllBatteries() {
        return ResponseEntity.ok(batteryService.getAllBatteries());
    }
}
