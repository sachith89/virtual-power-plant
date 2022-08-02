package com.sachith.api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tbl_vpp_battery")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BatteryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String postcode;
    private Integer capacity;
}
