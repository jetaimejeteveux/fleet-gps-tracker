/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.jetaimejeteveux.gpstracker.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jetaimejeteveux.gpstracker.domain.model.Vehicle;
/**
 *
 * @author firman
 */
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    boolean existsByPlateNumber(String plateNumber);
}
