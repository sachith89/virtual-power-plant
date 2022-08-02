package com.sachith.api.repository;

import com.sachith.api.entity.BatteryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatteryRepository extends JpaRepository<BatteryEntity, Long> {
}
