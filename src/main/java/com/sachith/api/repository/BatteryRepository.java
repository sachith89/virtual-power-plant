package com.sachith.api.repository;

import com.sachith.api.entity.BatteryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BatteryRepository extends JpaRepository<BatteryEntity, Long> {
    Optional<List<BatteryEntity>> findByPostcodeBetween(String fromPostCode, String toPostCode);
}
