package com.jetaimejeteveux.gpstracker.application.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jetaimejeteveux.gpstracker.application.dto.VehicleDto;
import com.jetaimejeteveux.gpstracker.application.mapper.VehicleMapper;
import com.jetaimejeteveux.gpstracker.domain.model.Vehicle;
import com.jetaimejeteveux.gpstracker.infrastructure.repository.VehicleRepository;
import com.jetaimejeteveux.gpstracker.presentation.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class VehicleService {

   private final VehicleRepository vehicleRepository;
   private final VehicleMapper vehicleMapper;
    
    @Transactional(readOnly = true)
    public List<VehicleDto> getAllVehicles() {
        return vehicleRepository.findAll().stream()
                .map(vehicleMapper::convertToDto)
                .collect(Collectors.toList());
    }
    
    @Transactional(readOnly = true)
    public VehicleDto getVehicleById(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle", "id", id));
        return vehicleMapper.convertToDto(vehicle);
    }
    
    @Transactional
    public VehicleDto createVehicle(VehicleDto vehicleDto) {
        if (vehicleRepository.existsByPlateNumber(vehicleDto.getPlateNumber())) {
            throw new DataIntegrityViolationException("Vehicle with plate number " + vehicleDto.getPlateNumber() + " already exists");
        }
        
        Vehicle vehicle = vehicleMapper.convertToEntity(vehicleDto);
        Vehicle savedVehicle = vehicleRepository.save(vehicle);
        return vehicleMapper.convertToDto(savedVehicle);
    }
}