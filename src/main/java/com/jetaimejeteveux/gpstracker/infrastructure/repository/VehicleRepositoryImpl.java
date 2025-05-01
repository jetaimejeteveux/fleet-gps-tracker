/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.jetaimejeteveux.gpstracker.infrastructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.jetaimejeteveux.gpstracker.domain.model.Vehicle;
import com.jetaimejeteveux.gpstracker.domain.repository.VehicleRepository;
import com.jetaimejeteveux.gpstracker.infrastructure.entity.VehicleEntity;
import com.jetaimejeteveux.gpstracker.infrastructure.mapper.VehicleEntityMapper;
import com.jetaimejeteveux.gpstracker.infrastructure.repository.jpa.VehicleJpaRepository;

import lombok.RequiredArgsConstructor;

/**
 *
 * @author firman
 */
@Repository
@RequiredArgsConstructor
public class VehicleRepositoryImpl implements VehicleRepository {

    private final VehicleJpaRepository jpaRepository;
    private final VehicleEntityMapper entityMapper;

    @Override
    public List<Vehicle> findAll() {
       List<VehicleEntity> vehicleEntitys = jpaRepository.findAll();
       return vehicleEntitys.stream()
               .map(entityMapper::toDomain)
               .toList();
    }

    @Override
    public Optional<Vehicle> findById(Long id) {
        Optional<VehicleEntity> vehicleEntity = jpaRepository.findById(id);
        return vehicleEntity.map(entityMapper::toDomain);
    }

    @Override
    public boolean existsByPlateNumber(String plateNumber) {
        return jpaRepository.existsByPlateNumber(plateNumber);
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        VehicleEntity vehicleEntity = entityMapper.toEntity(vehicle);
        VehicleEntity savedEntity = jpaRepository.save(vehicleEntity);
        return entityMapper.toDomain(savedEntity);
    }
}
