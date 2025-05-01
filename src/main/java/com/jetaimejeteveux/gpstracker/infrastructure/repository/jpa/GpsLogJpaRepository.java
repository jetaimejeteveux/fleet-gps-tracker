/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.jetaimejeteveux.gpstracker.infrastructure.repository.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jetaimejeteveux.gpstracker.infrastructure.entity.GpsLogEntity;

/**
 *
 * @author firman
 */
public interface GpsLogJpaRepository extends JpaRepository<GpsLogEntity, Long> {
    Optional<GpsLogEntity> findTopByVehicleIdOrderByTimestampDesc(Long vehicleId);
}
