package com.sachith.api.service;

import com.sachith.api.entity.BatteryEntity;
import com.sachith.api.repository.BatteryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BatteryService {

    private final BatteryRepository batteryRepository;

    public List<BatteryEntity> saveBattery(List<BatteryEntity> batteryEntities) {
        return batteryRepository.saveAll(batteryEntities);
    }

    public ResponseEntity<List<BatteryEntity>> getBatteriesByPostalCode(Integer fromPostCode, Integer toPostCode) {
        return null;
    }
}
