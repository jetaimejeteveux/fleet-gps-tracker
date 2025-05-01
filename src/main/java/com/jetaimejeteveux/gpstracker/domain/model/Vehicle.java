/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.jetaimejeteveux.gpstracker.domain.model;

import java.util.List;

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
 public class Vehicle {
     private Long id;
     private String plateNumber;
     private String name;
     private String type;
     private List<GpsLog> gpsLogs;
 }
