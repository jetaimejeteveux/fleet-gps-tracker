# Vehicle GPS Tracking Service

A Spring Boot service for tracking a fleet of vehicles in Indonesia. This service collects GPS data from vehicles and provides APIs to retrieve location information and movement history.

## Features

### Core Features

- REST API endpoints for GPS data submission and retrieval
- Vehicle tracking with current location and historical data
- PostgreSQL database for data persistence
- Validation for GPS coordinates and speed

### Bonus Features

- Speed violation detection and flagging

## Technology Stack

- Java 17
- Spring Boot 3.x
- PostgreSQL
- Flyway for database migrations
- Docker Compose for containerization
- JPA for ORM

## Database Schema

The database consists of the following tables:

1. `vehicles` - Stores vehicle information
2. `gps_logs` - Stores GPS location data from vehicles

## Setup and Installation

### Prerequisites

- Docker and Docker Compose
- Java 17 (for local development)
- Maven (for local development)

### Local Development Setup

1. Clone this repository:

   ```
   git clone <repository-url>
   cd vehicle-gps-tracking
   ```

2. Start PostgreSQL using Docker:

   ```
   docker-compose up -d
   ```

3. Build and run the application:
   ```
   ./mvnw spring-boot:run
   ```

## API Endpoints

### Vehicle GPS Tracking

- `POST /api/v1/vehicles` - Add new vehicle
- `GET /api/v1/vehicles/{id}` - Get vehicle by Id
- `GET /api/v1/vehicles` - Get all vehicle
- `POST /api/v1/gps` - Submit GPS log data
- `GET /api/v1/vehicles/{id}/last-location` - Get latest location of a vehicle
- `GET /api/v1/vehicles/{id}/history?from=&to=` - Get location history within time range

### Sample API Requests

#### Submit GPS Log

```
POST /api/gps
Content-Type: application/json
{
  "vehicleId": 1,
  "latitude": -6.175110,
  "longitude": 106.865036,
  "speed": 45.5,
  "timestamp": "2025-04-30T10:15:30Z"
}
```

#### Get Latest Location

```
GET /api/vehicles/1/last-location
Authorization: Bearer <jwt-token>
```

#### Get Location History

```
GET /api/vehicles/1/history?from=2025-04-29T00:00:00Z&to=2025-04-30T23:59:59Z
Authorization: Bearer <jwt-token>
```

## Design Decisions and Assumptions

1. **Data Model Design**:

   - Used separate tables for vehicles, GPS logs, and speed violations for better data organization
   - Added indexes on frequently queried columns for better performance

2. **API Design**:

   - Followed RESTful principles with clean, descriptive endpoints
   - Used proper HTTP methods and status codes

3. **Security**:

   - Implemented JWT-based authentication for API security
   - Used environment variables for sensitive configuration

4. **Performance Considerations**:

   - Added database indexes for faster querying
   - Designed database schema for efficient retrieval of location history

5. **Monitoring and Maintenance**:
   - Added scheduled task to clean up old GPS logs to manage database size

## Future Improvements

1. Implement pagination for history endpoints to handle large datasets
2. Add geofencing capabilities to define allowed operational areas
3. Implement real-time notifications for speed violations
4. Add vehicle grouping/fleet management features
5. Enhance authentication with role-based access control
6. Add reporting functionality for fleet operators
