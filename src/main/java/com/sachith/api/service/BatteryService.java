package com.sachith.api.service;

import com.sachith.api.dto.BatteryListResponse;
import com.sachith.api.entity.BatteryEntity;
import com.sachith.api.repository.BatteryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BatteryService {

    private final BatteryRepository batteryRepository;

    @Transactional
    public List<BatteryEntity> saveBattery(List<BatteryEntity> batteryEntities) {
        return batteryRepository.saveAll(batteryEntities);
    }

    public List<BatteryEntity> getBatteriesByPostalCode(String fromPostCode, String toPostCode) {
        return batteryRepository.findByPostcodeBetween(fromPostCode, toPostCode).get();
    }

    public BatteryListResponse getAllBatteries() {

        BatteryListResponse batteryListResponse = new BatteryListResponse();

        List<BatteryEntity> batteryList = batteryRepository.findAll();

        IntSummaryStatistics collect = batteryList.stream()
                .collect(Collectors.summarizingInt(BatteryEntity::getCapacity));
        batteryListResponse.setAverageCapacity(collect.getAverage());
        batteryListResponse.setCount(collect.getCount());
        batteryListResponse.setBatteryEntityList(batteryList);

        return batteryListResponse;
    }
}
