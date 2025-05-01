/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.jetaimejeteveux.gpstracker.application.mapper;

import org.springframework.stereotype.Component;

import com.jetaimejeteveux.gpstracker.application.dto.GpsLogDto;
import com.jetaimejeteveux.gpstracker.domain.model.GpsLog;

/**
 *
 * @author firman
 */

@Component
public class GpsLogDtoMapper {
    public static GpsLogDto toDto(GpsLog domain) {
        if (domain == null) return null;

        return GpsLogDto.builder()
                .id(domain.getId())
                .vehicleId(domain.getVehicleId())
                .latitude(domain.getLatitude())
                .longitude(domain.getLongitude())
                .speed(domain.getSpeed())
                .timestamp(domain.getTimestamp())
                .build();
    }

    public static GpsLog toDomain(GpsLogDto dto) {
        if (dto == null) return null;

        return GpsLog.builder()
                .id(dto.getId())
                .vehicleId(dto.getVehicleId())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .speed(dto.getSpeed())
                .timestamp(dto.getTimestamp())
                .build();
    }
}

