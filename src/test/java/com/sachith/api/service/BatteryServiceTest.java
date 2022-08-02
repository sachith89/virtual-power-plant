package com.sachith.api.service;

import com.sachith.api.entity.BatteryEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class BatteryServiceTest {

    @Autowired
    private BatteryService batteryService;


    @Test
    public void successfullySaveBatteryWhenAllDataCorrect() {
        BatteryEntity battery = new BatteryEntity();
        battery.setName("Amaron");
        battery.setPostcode("1000");
        battery.setCapacity(13000);

        List<BatteryEntity> batteryEntities = new ArrayList<>();
        batteryEntities.add(battery);

        List<BatteryEntity> batteryEntity = batteryService.saveBattery(batteryEntities);

        Assertions.assertEquals(battery.getName(), batteryEntity.get(0).getName());
    }
}
