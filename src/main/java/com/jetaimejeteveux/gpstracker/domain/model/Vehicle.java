/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.jetaimejeteveux.gpstracker.domain.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author firman
 */

@Entity
@Table(name = "vehicles")
@Data
@Builder
@NoArgsConstructor 
@AllArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Plate number is required")
    @Column(name = "plate_number", nullable = false, unique = true)
    private String plateNumber;

    @NotBlank(message = "Vehicle name is required")
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "Vehicle type is required")
    @Column(name = "type", nullable = false)
    private String type;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GpsLog> gpsLogs = new ArrayList<>();
}
