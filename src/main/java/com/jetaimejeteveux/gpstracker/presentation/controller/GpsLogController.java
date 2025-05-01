/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.jetaimejeteveux.gpstracker.presentation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jetaimejeteveux.gpstracker.application.dto.GpsLogDto;
import com.jetaimejeteveux.gpstracker.application.service.GpsLogService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

/**
 *
 * @author firman
 */

@RestController
@RequestMapping("/api/v1/gps")
@RequiredArgsConstructor
public class GpsLogController {
    private final GpsLogService gpsLogService;

    @PostMapping()
    public ResponseEntity<GpsLogDto> createGpsLog(@Valid @RequestBody GpsLogDto gpsLogDto) {
        GpsLogDto createdGpsLog = gpsLogService.logGpsData(gpsLogDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGpsLog);
    }
}
