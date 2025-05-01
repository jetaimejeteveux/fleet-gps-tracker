/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.jetaimejeteveux.gpstracker.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
@Schema(description = "Request payload for submitting GPS data")
public class GpsLogRequest {
    
    @NotNull(message = "Vehicle ID is required")
    @Schema(description = "ID of the vehicle sending GPS data", example = "1")
    private Long vehicleId;
    
    @NotNull(message = "Latitude is required")
    @Min(value = -90, message = "Latitude must be between -90 and 90")
    @Max(value = 90, message = "Latitude must be between -90 and 90")
    @Schema(description = "Latitude coordinate", example = "-6.2088")
    private Double latitude;
    
    @NotNull(message = "Longitude is required")
    @Min(value = -180, message = "Longitude must be between -180 and 180")
    @Max(value = 180, message = "Longitude must be between -180 and 180")
    @Schema(description = "Longitude coordinate", example = "106.8456")
    private Double longitude;
    
    @NotNull(message = "Speed is required")
    @Min(value = 0, message = "Speed cannot be negative")
    @Schema(description = "Vehicle speed in km/h", example = "60.5")
    private Double speed;
}
