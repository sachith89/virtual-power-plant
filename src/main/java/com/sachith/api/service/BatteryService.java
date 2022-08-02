package com.sachith.api.service;

import com.sachith.api.entity.BatteryEntity;
import com.sachith.api.repository.BatteryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BatteryService {

    private final BatteryRepository batteryRepository;

    @Transactional
    public List<BatteryEntity> saveBattery(List<BatteryEntity> batteryEntities) {
        return batteryRepository.saveAll(batteryEntities);
    }


    public List<BatteryEntity> getBatteriesByPostalCode(String fromPostCode, String toPostCode) {
        return batteryRepository.findByPostcodeBetween(fromPostCode,toPostCode).get();
    }
}
