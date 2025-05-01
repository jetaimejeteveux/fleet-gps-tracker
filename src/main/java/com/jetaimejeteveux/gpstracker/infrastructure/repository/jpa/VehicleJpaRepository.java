/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.jetaimejeteveux.gpstracker.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jetaimejeteveux.gpstracker.infrastructure.repository.entity.VehicleEntity;
/**
 *
 * @author firman
 */
public interface VehicleJpaRepository extends JpaRepository<VehicleEntity, Long> {
    boolean existsByPlateNumber(String plateNumber);
}
