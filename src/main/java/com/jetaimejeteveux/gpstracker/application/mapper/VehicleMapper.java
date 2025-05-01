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
public class VehicleMapper {
    public VehicleDto convertToDto(Vehicle vehicle) {
        return VehicleDto.builder()
                .id(vehicle.getId())
                .plateNumber(vehicle.getPlateNumber())
                .name(vehicle.getName())
                .type(vehicle.getType())
                .build();
    }
    
    public Vehicle convertToEntity(VehicleDto vehicleDto) {
        return Vehicle.builder()
                .id(vehicleDto.getId())
                .plateNumber(vehicleDto.getPlateNumber())
                .name(vehicleDto.getName())
                .type(vehicleDto.getType())
                .build();
    }
}
