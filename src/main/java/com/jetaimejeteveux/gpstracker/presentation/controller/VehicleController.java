/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.jetaimejeteveux.gpstracker.presentation.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jetaimejeteveux.gpstracker.application.dto.LocationResponse;
import com.jetaimejeteveux.gpstracker.application.dto.VehicleDto;
import com.jetaimejeteveux.gpstracker.application.service.GpsLogService;
import com.jetaimejeteveux.gpstracker.application.service.VehicleService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;




/**
 *
 * @author firman
 */

@RestController
@RequestMapping("/api/v1/vehicles")
@RequiredArgsConstructor
public class VehicleController {
    private final VehicleService vehicleService;
    private final GpsLogService gpsLogService; 

    @PostMapping()
    @Operation(summary = "Create a new vehicle", description = "Register a new vehicle in the system")
    public ResponseEntity<VehicleDto> createVehicle(@Valid @RequestBody VehicleDto vehicleDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(vehicleService.createVehicle(vehicleDto));
        
    }

    @GetMapping()
    @Operation(summary = "Get all vehicles", description = "Retrieve all vehicles")
    public ResponseEntity<List<VehicleDto>> getAllVehicles() {
        List<VehicleDto> vehicles = vehicleService.getAllVehicles();
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get vehicle by ID", description = "Retrieve a vehicle by its ID")
    public ResponseEntity<VehicleDto> getVehicleById(@PathVariable Long id) {
        return ResponseEntity.ok(vehicleService.getVehicleById(id));
    }

    @GetMapping("/{id}/last-location")
    @Operation(summary = "Get last known location", description = "Get the most recent GPS location of the vehicle")
    public ResponseEntity<LocationResponse> getLastLocation(@PathVariable("id") Long vehicleId) {
        return ResponseEntity.ok(gpsLogService.getLatestGpsLocation(vehicleId));
    }

    @GetMapping("/{id}/history")
    @Operation(summary = "Get location history", description = "Retrieve GPS data for a vehicle within a time range")
    public ResponseEntity<List<LocationResponse>> getLocationHistory(
            @PathVariable("id") Long vehicleId,
            @RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime from,
            @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime to) {
        
        return ResponseEntity.ok(gpsLogService.getLocationHistory(vehicleId, from, to));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update vehicle", description = "Update vehicle details")
    public ResponseEntity<VehicleDto> updateVehicle(@PathVariable Long id, @RequestBody VehicleDto vehicleDto) {
        return ResponseEntity.ok(vehicleService.updateVehicle(id, vehicleDto));
    }
}
