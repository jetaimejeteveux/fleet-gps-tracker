/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.jetaimejeteveux.gpstracker.application.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jetaimejeteveux.gpstracker.application.dto.GpsLogDto;
import com.jetaimejeteveux.gpstracker.application.mapper.GpsLogDtoMapper;
import com.jetaimejeteveux.gpstracker.domain.model.GpsLog;
import com.jetaimejeteveux.gpstracker.domain.model.Vehicle;
import com.jetaimejeteveux.gpstracker.domain.repository.GpsLogRepository;
import com.jetaimejeteveux.gpstracker.domain.repository.VehicleRepository;
import com.jetaimejeteveux.gpstracker.infrastructure.entity.VehicleEntity;
import com.jetaimejeteveux.gpstracker.infrastructure.mapper.VehicleEntityMapper;
import com.jetaimejeteveux.gpstracker.infrastructure.repository.jpa.VehicleJpaRepository;
import com.jetaimejeteveux.gpstracker.presentation.exception.ResourceNotFoundException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author firman
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class GpsLogService {
    private final GpsLogRepository gpsRepository;
    private final VehicleRepository vehicleRepository;
    private final VehicleEntityMapper vehicleEntityMapper;
    private final GpsLogDtoMapper gpsLogDtoMapper;
    private final VehicleJpaRepository vehicleJpaRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public GpsLogDto logGpsData(GpsLogDto gpsLogDto) {
        Vehicle vehicle = vehicleRepository.findById(gpsLogDto.getVehicleId())
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found with id: " + gpsLogDto.getVehicleId()));
        VehicleEntity vehicleEntity = vehicleEntityMapper.toEntity(vehicle);

        gpsLogDto.setTimestamp(LocalDateTime.now());

        GpsLog gpsLog = gpsLogDtoMapper.toDomain(gpsLogDto);
        GpsLog savedGpsLog = gpsRepository.save(gpsLog, vehicleEntity);

        log.info("GPS data logged for vehicle ID: {}, Speed: {}", 
                vehicle.getId(), gpsLogDto.getSpeed());

        return gpsLogDtoMapper.toDto(savedGpsLog);
    }
}
