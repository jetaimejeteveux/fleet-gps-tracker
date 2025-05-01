/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.jetaimejeteveux.gpstracker.domain.repository;

import java.util.List;
import java.util.Optional;

import com.jetaimejeteveux.gpstracker.domain.model.Vehicle;

/**
 *
 * @author firman
 */
public interface VehicleRepository {
    List<Vehicle> findAll();
    Optional<Vehicle> findById(Long id);
    boolean existsByPlateNumber(String plateNumber);
    Vehicle save(Vehicle vehicle);
}   
