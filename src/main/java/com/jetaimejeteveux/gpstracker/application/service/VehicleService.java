package com.jetaimejeteveux.gpstracker.application.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jetaimejeteveux.gpstracker.application.dto.VehicleDto;
import com.jetaimejeteveux.gpstracker.application.mapper.VehicleDtoMapper;
import com.jetaimejeteveux.gpstracker.domain.model.Vehicle;
import com.jetaimejeteveux.gpstracker.domain.repository.GpsLogRepository;
import com.jetaimejeteveux.gpstracker.domain.repository.VehicleRepository;
import com.jetaimejeteveux.gpstracker.infrastructure.mapper.VehicleEntityMapper;
import com.jetaimejeteveux.gpstracker.presentation.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class VehicleService {
    private final VehicleRepository vehicleRepository;
    private final GpsLogRepository gpsLogRepository;
    private final VehicleDtoMapper vehicleDtoMapper;    
    private final VehicleEntityMapper vehicleEntityMapper;

    @Transactional(readOnly = true)
    public List<VehicleDto> getAllVehicles() {
        return vehicleRepository.findAll().stream()
                .map(vehicleDtoMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public VehicleDto getVehicleById(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found with id: " + id));
        return vehicleDtoMapper.toDto(vehicle);
    }

    @Transactional
    public VehicleDto createVehicle(VehicleDto vehicleDto) {
        if (vehicleRepository.existsByPlateNumber(vehicleDto.getPlateNumber())) {
            throw new DataIntegrityViolationException("Vehicle with plate number " + vehicleDto.getPlateNumber() + " already exists");
        }
        Vehicle vehicle = vehicleDtoMapper.toDomain(vehicleDto);
        Vehicle savedVehicle = vehicleRepository.save(vehicle);
        return vehicleDtoMapper.toDto(savedVehicle);
    }

    @Transactional
    public VehicleDto updateVehicle(Long id, VehicleDto vehicleDto) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found with id: " + id));

        vehicle.setPlateNumber(vehicleDto.getPlateNumber());
        vehicle.setName(vehicleDto.getName());
        vehicle.setType(vehicleDto.getType());
        Vehicle updatedVehicle = vehicleRepository.save(vehicle);

        return vehicleDtoMapper.toDto(updatedVehicle);
    }
}