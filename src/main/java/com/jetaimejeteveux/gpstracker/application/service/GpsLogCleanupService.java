/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.jetaimejeteveux.gpstracker.application.service;

import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.jetaimejeteveux.gpstracker.domain.repository.GpsLogRepository;
import com.jetaimejeteveux.gpstracker.infrastructure.config.GpsLogConfig;
import lombok.RequiredArgsConstructor;

/**
 *
 * @author firman
 */
@Service
@RequiredArgsConstructor
public class GpsLogCleanupService {

    private final GpsLogRepository gpsLogRepository;
    private final GpsLogConfig gpsLogConfig;
    private final Logger logger = LoggerFactory.getLogger(GpsLogCleanupService.class);

    @Scheduled(cron = "0 0 0 * * ?") // Run at midnight every day
    public void cleanupOldLogs() {
        try {
            LocalDateTime cutoffDate = LocalDateTime.now().minusDays(gpsLogConfig.getRetentionDays());
            int deletedCount = gpsLogRepository.deleteByTimestampsBefore(cutoffDate);
            logger.info("Cleaned up {} GPS logs older than {} days", deletedCount, gpsLogConfig.getRetentionDays());
        } catch (Exception e) {
            logger.error("Error cleaning up old GPS logs: {}", e.getMessage(), e);
        }
    }
}
