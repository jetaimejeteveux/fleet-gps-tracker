/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.jetaimejeteveux.gpstracker.domain.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.jetaimejeteveux.gpstracker.domain.model.GpsLog;
import com.jetaimejeteveux.gpstracker.infrastructure.entity.VehicleEntity;

/**
 *
 * @author firman
 */
public interface GpsLogRepository {
    GpsLog save(GpsLog gpsLog, VehicleEntity vehicleEntity);
    Optional<GpsLog> findLatestByVehicleId(Long vehicleId);
    List<GpsLog> findAllByVehicleIdAndTimestampBetween(Long vehicleId, LocalDateTime from, LocalDateTime to);
}
