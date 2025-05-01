/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.jetaimejeteveux.gpstracker.application.dto;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author firman
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Response with vehicle location information")
public class LocationResponse {
    
    @Schema(description = "Vehicle ID", example = "1")
    private Long vehicleId;
    
    @Schema(description = "Vehicle plate number", example = "B1234CD")
    private String plateNumber;
    
    @Schema(description = "Vehicle name", example = "Delivery Truck 01")
    private String vehicleName;
    
    @Schema(description = "Latitude coordinate", example = "-6.2088")
    private Double latitude;
    
    @Schema(description = "Longitude coordinate", example = "106.8456")
    private Double longitude;
    
    @Schema(description = "Vehicle speed in km/h", example = "60.5")
    private Double speed;
    
    @Schema(description = "Timestamp of the GPS log", example = "2023-12-01T14:30:00")
    private LocalDateTime timestamp;
    
    @Schema(description = "Whether this log indicates a speed violation", example = "false")
    private Boolean speedViolation;
}