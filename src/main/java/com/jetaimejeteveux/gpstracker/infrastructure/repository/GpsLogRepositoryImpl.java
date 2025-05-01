/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.jetaimejeteveux.gpstracker.infrastructure.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.jetaimejeteveux.gpstracker.domain.model.GpsLog;
import com.jetaimejeteveux.gpstracker.domain.repository.GpsLogRepository;
import com.jetaimejeteveux.gpstracker.infrastructure.entity.GpsLogEntity;
import com.jetaimejeteveux.gpstracker.infrastructure.entity.VehicleEntity;
import com.jetaimejeteveux.gpstracker.infrastructure.mapper.GpsLogEntityMapper;
import com.jetaimejeteveux.gpstracker.infrastructure.repository.jpa.GpsLogJpaRepository;

import lombok.RequiredArgsConstructor;

/**
 *
 * @author firman
 */

@Repository
@RequiredArgsConstructor
public class GpsLogRepositoryImpl implements GpsLogRepository {
    
    private final GpsLogJpaRepository gpsLogJpaRepository;
    private final GpsLogEntityMapper gpsLogEntityMapper;

    @Override
    public GpsLog save(GpsLog gpsLog, VehicleEntity vehicleEntity) {
        GpsLogEntity gpsLogEntity = gpsLogEntityMapper.toEntity(gpsLog, vehicleEntity);
        GpsLogEntity savedEntity = gpsLogJpaRepository.save(gpsLogEntity);
        return gpsLogEntityMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<GpsLog> findLatestByVehicleId(Long vehicleId) {
        return gpsLogJpaRepository.findTopByVehicleIdOrderByTimestampDesc(vehicleId)
                .map(GpsLogEntityMapper::toDomain);
    }

    @Override
    public List<GpsLog> findAllByVehicleIdAndTimestampBetween(Long vehicleId, LocalDateTime fromTime, LocalDateTime toTime) {
        return gpsLogJpaRepository.findAllByVehicleIdAndTimestampBetween(vehicleId, fromTime, toTime)
                .stream()
                .map(GpsLogEntityMapper::toDomain)
                .toList();
    }

}
