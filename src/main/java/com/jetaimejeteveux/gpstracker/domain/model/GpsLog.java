/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.jetaimejeteveux.gpstracker.domain.model;

import java.time.LocalDateTime;

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
 public class GpsLog {
     private Long id;
     private Long vehicleId;
     private Double latitude;
     private Double longitude;
     private Double speed;
     private LocalDateTime timestamp;
 }
 
