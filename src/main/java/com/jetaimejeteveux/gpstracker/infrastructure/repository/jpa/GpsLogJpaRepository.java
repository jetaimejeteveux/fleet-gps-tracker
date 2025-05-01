/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.jetaimejeteveux.gpstracker.infrastructure.repository.jpa;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jetaimejeteveux.gpstracker.infrastructure.entity.GpsLogEntity;

/**
 *
 * @author firman
 */
public interface GpsLogJpaRepository extends JpaRepository<GpsLogEntity, Long> {
    Optional<GpsLogEntity> findTopByVehicleIdOrderByTimestampDesc(Long vehicleId);
    @Query("SELECT g FROM GpsLogEntity g WHERE g.vehicle.id = :vehicleId AND g.timestamp BETWEEN :fromTime AND :toTime ORDER BY g.timestamp")
    List<GpsLogEntity> findAllByVehicleIdAndTimestampBetween(
            @Param("vehicleId") Long vehicleId,
            @Param("fromTime") LocalDateTime fromTime,
            @Param("toTime") LocalDateTime toTime);
}
