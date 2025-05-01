/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.jetaimejeteveux.gpstracker.application.mapper;

import org.springframework.stereotype.Component;

import com.jetaimejeteveux.gpstracker.application.dto.VehicleDto;
import com.jetaimejeteveux.gpstracker.domain.model.Vehicle;

/**
 *
 * @author firman
 */

@Component
public class VehicleDtoMapper {
    public VehicleDto toDto(Vehicle domain) {
        if (domain == null) return null;

        return VehicleDto.builder()
                .id(domain.getId())
                .plateNumber(domain.getPlateNumber())
                .name(domain.getName())
                .type(domain.getType())
                .build();
    }

    public static Vehicle toDomain(VehicleDto dto) {
        if (dto == null) return null;

        return Vehicle.builder()
                .id(dto.getId())
                .plateNumber(dto.getPlateNumber())
                .name(dto.getName())
                .type(dto.getType())
                .build();
    }
}