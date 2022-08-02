package com.sachith.api.repository;

import com.sachith.api.entity.BatteryEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BatteryRepositoryTest {

    @Autowired
    private BatteryRepository underTest;


    @Test
    public void shouldFindBatteriesByPostcodeRange() {
        // Given
        BatteryEntity battery1 = new BatteryEntity(1L, "Cannington", "6107", 13500);
        BatteryEntity battery2 = new BatteryEntity(2L, "Midland", "6057", 50500);
        BatteryEntity battery3 = new BatteryEntity(3L, "Hay Street", "6000", 23500);
        // When
        underTest.save(battery1);
        underTest.save(battery2);
        underTest.save(battery3);

        // Then
        Optional<List<BatteryEntity>> list = underTest.findByPostcodeBetween("6000", "6060");
        assertThat(list.get())
                .hasSize(2)
                .extracting(BatteryEntity::getName)
                .containsExactlyInAnyOrder("Midland", "Hay Street");
    }
}


