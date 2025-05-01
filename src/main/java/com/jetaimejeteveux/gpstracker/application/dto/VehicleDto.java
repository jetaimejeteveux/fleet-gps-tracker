/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.jetaimejeteveux.gpstracker.application.dto;

import jakarta.validation.constraints.NotBlank;
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
public class VehicleDto {
    private Long id;

    @NotBlank(message = "Plate number is required")
    private String plateNumber;

    @NotBlank(message = "Vehicle name is required")
    private String name;

    @NotBlank(message = "Vehicle type is required")
    private String type;

}
