-- Add indexes for faster querying
CREATE INDEX idx_gps_logs_vehicle_id ON gps_logs(vehicle_id);
CREATE INDEX idx_gps_logs_timestamp ON gps_logs(timestamp);
CREATE INDEX idx_gps_logs_vehicle_timestamp ON gps_logs(vehicle_id, timestamp);