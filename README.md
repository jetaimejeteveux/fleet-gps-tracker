````markdown
# Fleet GPS Tracking Microservice

A simplified Spring Boot-based backend service for tracking the GPS data of a vehicle fleet across Indonesia.

## Features

- [x] RESTful API for GPS data ingestion and retrieval
- [x] PostgreSQL with JPA/Hibernate for persistence
- [x] Flyway for database migrations
- [x] Speed violation detection (speed > 100 km/h)
- [x] Scheduled cleanup of old GPS logs (configurable)
- [x] OpenAPI (Swagger) documentation
- [x] Input validation and error handling
- [x] Dockerized deployment setup

---

## Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Flyway
- Swagger/OpenAPI
- Maven
- Docker & Docker Compose

---

## Setup Instructions

### Prerequisites

- Java 17+
- Docker + Docker Compose
- Maven (for local development, optional)

---

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/fleet-gps-tracker.git
cd fleet-gps-tracker
```
````

---

### 2. Run with Docker Compose (Recommended)

```bash
docker-compose up --build -d
```

This will:

- Build and start the Spring Boot app
- Start PostgreSQL and pgAdmin
- Apply Flyway migrations automatically

App will be available at:
`http://localhost:8080` (API)
`http://localhost:8080/swagger-ui/index.html` (Swagger UI)
`http://localhost:5050` (pgAdmin)

**pgAdmin credentials:**

- Email: `admin@fleetgps.com`
- Password: `admin`

**Database connection in pgAdmin:**

- Host: `db`
- Port: `5432`
- Username: `postgres`
- Password: `postgres`

---

### 3. (Optional) Manual Run for Local Development

#### Configure `application.properties`

```properties
spring.datasource.url=jdbc:postgresql://localhost:5433/fleet_gps
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.datasource.driver-class-name=org.postgresql.Driver
spring.flyway.enabled=true
spring.jpa.hibernate.ddl-auto=validate
```

#### Run Flyway migration manually

```bash
./mvnw flyway:migrate \
  -Dflyway.url=jdbc:postgresql://localhost:5433/fleet_gps \
  -Dflyway.user=postgres \
  -Dflyway.password=postgres
```

#### Start the application

```bash
./mvnw spring-boot:run
```

---

## API Endpoints

### GPS Log Ingestion

**POST** `/api/gps`
**Payload:**

```json
{
  "vehicleId": 1,
  "latitude": -6.2,
  "longitude": 106.816666,
  "speed": 85.0,
  "timestamp": "2025-05-01T12:00:00Z"
}
```

---

### Get Last Known Location

**GET** `/api/vehicles/{id}/last-location`

---

### Get GPS History (optional time range)

**GET** `/api/vehicles/{id}/history?from=2025-04-01T00:00:00Z&to=2025-04-30T23:59:59Z`

---

## Database Migration

Flyway is used to manage schema migrations. SQL files are located in:

```
src/main/resources/db/migration
```

Migrations run automatically in Docker setup, or can be run manually as shown above.

---

## Configurations

### Scheduled Cleanup

GPS logs older than `X` days are deleted on a schedule.

Configurable in `application.properties`:

```properties
app.gps-log.retention-days=30
```

---

## Future Enhancements

- [ ] JWT-based user authentication
- [ ] Unit and integration tests
- [ ] Performance optimization (pagination, query tuning)

---

## Postman Collection

A Postman collection is available in `postman/fleet - gps tracker.postman_collection.json`.

---

## Assumptions

- Vehicle entities must exist before sending GPS logs (sample data seeded via `V2__seed_data.sql`)
- Speed violations are flagged when `speed > 100 km/h`
- All timestamps are in UTC

---

## Author

- (https://github.com/jetaimejeteveux)

```

```
