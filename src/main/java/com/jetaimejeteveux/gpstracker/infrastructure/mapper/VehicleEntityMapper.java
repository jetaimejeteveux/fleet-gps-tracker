/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.jetaimejeteveux.gpstracker.infrastructure.mapper;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.jetaimejeteveux.gpstracker.domain.model.Vehicle;
import com.jetaimejeteveux.gpstracker.infrastructure.repository.entity.VehicleEntity;

/**
 *
 * @author firman
 */

@Component
public class VehicleEntityMapper {
    public VehicleEntity toEntity(Vehicle domain) {
        if (domain == null) return null;

        return VehicleEntity.builder()
                .id(domain.getId())
                .plateNumber(domain.getPlateNumber())
                .name(domain.getName())
                .type(domain.getType())
                .build();
    }

    public Vehicle toDomain(VehicleEntity entity) {
        if (entity == null) return null;

        return Vehicle.builder()
                .id(entity.getId())
                .plateNumber(entity.getPlateNumber())
                .name(entity.getName())
                .type(entity.getType())
                .gpsLogs(entity.getGpsLogs() != null
                        ? entity.getGpsLogs().stream()
                            .map(GpsLogEntityMapper::toDomain)
                            .collect(Collectors.toList())
                        : null)
                .build();
    }
}
