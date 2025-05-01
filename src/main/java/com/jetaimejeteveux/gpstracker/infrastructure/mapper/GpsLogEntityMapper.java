/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.jetaimejeteveux.gpstracker.infrastructure.mapper;

import org.springframework.stereotype.Component;

import com.jetaimejeteveux.gpstracker.domain.model.GpsLog;
import com.jetaimejeteveux.gpstracker.infrastructure.entity.GpsLogEntity;
import com.jetaimejeteveux.gpstracker.infrastructure.entity.VehicleEntity;

/**
 *
 * @author firman
 */

@Component
public class GpsLogEntityMapper {
    public GpsLogEntity toEntity(GpsLog domain, VehicleEntity vehicleEntity) {
        if (domain == null) return null;

        return GpsLogEntity.builder()
                .id(domain.getId())
                .vehicle(vehicleEntity)
                .latitude(domain.getLatitude())
                .longitude(domain.getLongitude())
                .speed(domain.getSpeed())
                .timestamp(domain.getTimestamp())
                .speedViolation(domain.getSpeedViolation())
                .build();
    }

    public static GpsLog toDomain(GpsLogEntity entity) {
        if (entity == null) return null;

        return GpsLog.builder()
                .id(entity.getId())
                .vehicleId(entity.getVehicle() != null ? entity.getVehicle().getId() : null)
                .latitude(entity.getLatitude())
                .longitude(entity.getLongitude())
                .speed(entity.getSpeed())
                .timestamp(entity.getTimestamp())
                .speedViolation(entity.getSpeedViolation())
                .build();
    }

}
