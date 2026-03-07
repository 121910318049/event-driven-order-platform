# Event Driven Order Processing Platform

## Overview

This project demonstrates an **event-driven microservices architecture** built using **Spring Boot, Apache Kafka, Docker, and PostgreSQL**.

The system processes an order through multiple independent services using **Kafka event streaming**. Each service reacts to events and performs its own responsibility, enabling **loose coupling and scalability**.

---

# Architecture

```
                +-------------+
                |   Client    |
                |  (Postman)  |
                +------+------+
                       |
                       v
               +--------------+
               | order-service|
               +------+-------+
                      |
                      | Event: order-created
                      v
                 +---------+
                 |  Kafka  |
                 +----+----+
                      |
                      v
              +---------------+
              | payment-service|
              +-------+-------+
                      |
                      | Event: payment-completed
                      v
                 +---------+
                 |  Kafka  |
                 +----+----+
                      |
                      v
             +----------------+
             | inventory-service|
             +--------+--------+
                      |
                      | Event: inventory-updated
                      v
                 +---------+
                 |  Kafka  |
                 +----+----+
                      |
                      v
           +---------------------+
           | notification-service|
           +---------------------+
```

---

# Microservices

### order-service

* Accepts order requests
* Persists order data in PostgreSQL
* Publishes **order-created** event to Kafka

### payment-service

* Consumes **order-created**
* Processes payment
* Publishes **payment-completed**

### inventory-service

* Consumes **payment-completed**
* Updates inventory
* Publishes **inventory-updated**

### notification-service

* Consumes **inventory-updated**
* Sends order notifications (currently logged)

---

# Kafka Topics

| Topic             | Producer          | Consumer             |
| ----------------- | ----------------- | -------------------- |
| order-created     | order-service     | payment-service      |
| payment-completed | payment-service   | inventory-service    |
| inventory-updated | inventory-service | notification-service |

Kafka acts as the **event backbone** connecting all microservices.

---

# Tech Stack

* Java 17
* Spring Boot
* Apache Kafka
* PostgreSQL
* Docker
* Maven

---

# Project Structure

```
event-driven-order-platform
│
├── docker-compose.yml
│
├── order-service
├── payment-service
├── inventory-service
└── notification-service
```

Each service is **independently deployable** and communicates through Kafka events.

---

# Running the Project

## Build Services

```
mvn clean package
```

## Start Infrastructure

```
docker-compose up --build
```

This will start:

* PostgreSQL
* Zookeeper
* Kafka
* All microservices

---

# Test the System

Create an order:

```
POST http://localhost:8081/orders
```

Example request:

```
{
  "orderId": "ORD1001",
  "amount": 500
}
```

Event flow:

```
Order Created
     ↓
Payment Processed
     ↓
Inventory Updated
     ↓
Notification Triggered
```

---

# Event Driven Design

Benefits of this architecture:

* Loose coupling between services
* High scalability
* Fault isolation
* Independent deployments

---

# Future Improvements

* Dead Letter Queue (DLQ)
* Retry mechanisms
* Schema validation for Kafka events
* Centralized logging
* Distributed tracing

---

# Author

Sai Pavan Naresh
