# Scoober Backend Application

This application is a delivery tracking system and courier assignment tool built using Java, Spring Boot, MongoDB, Kafka, and Docker. It manages the complete lifecycle of an order, from placement to delivery, including real-time courier assignment and estimated time of arrival (ETA) calculations.

## Features
- **Order Management:** Create and manage orders with statuses (`PLACED`, `ASSIGNED`, `DELIVERED`).
- **Courier Management:** Register and manage courier data.
- **Real-Time Tracking:** Track deliveries in real-time with calculated ETAs using geographical data.
- **Kafka Integration:** Event-driven communication with Kafka topics (`order_placed`).

## Technology Stack
- **Java 17**
- **Spring Boot 3.3.0**
- **MongoDB 5**
- **Kafka 7.0.1**
- **Docker**

## Prerequisites
- Java 17 or higher
- Maven
- Docker and Docker Compose

## Getting Started

### Clone the repository

```bash
git clone [repository-url]
cd scoober-backend
```
### Build the project

```bash
./mvnw clean package
```

### Run the application using Docker Compose

```bash
docker-compose up -d
```

After running the above command, the following services will be up and running:

- MongoDB: localhost:27017
- Kafka: localhost:9092
- Kafka UI: localhost:8085
- Scoober Backend Application: localhost:8080

## API Endpoints

### Order API

- POST /api/orders: Place a new order
(Triggers Kafka order_placed event)

Example request:
```json
{
  "location": {
    "lat": 52.3676,
    "lng": 4.9041
  }
}
```

### Courier API
- POST /api/couriers: Add a new courier

Example request:
```json
{
  "name": "John Doe",
  "latitude": 52.3676,
  "longitude": 4.9041
}
```

- GET /api/couriers: Retrieve all couriers

### Health Check

- GET /ping: Check application health
- Response: "pong"

## Kafka Topics

- order_placed: Published when a new order is placed.

## Utility
- ETA Calculation: Uses the Haversine formula to estimate delivery times based on geographic coordinates.

## Additional Documentation
- [Spring Boot Documentation](https://docs.spring.io/spring-boot/)
- [Kafka Documentation](https://kafka.apache.org/documentation/)
- [MongoDB Documentation](https://www.mongodb.com/docs/)

## License

This project is open-source and available under the [MIT License](https://opensource.org/license/mit)

