-- Add the speed_violation column to the gps_logs table
ALTER TABLE gps_logs
ADD COLUMN speed_violation BOOLEAN DEFAULT FALSE;