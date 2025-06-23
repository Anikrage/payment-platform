# 💳 Payment Platform Microservices

This project is a microservice-based payment processing system built with Spring Boot, Docker, and Kubernetes. It includes services for user management, payment processing, transactions, and notifications, all routed via an API Gateway.

---

## 📦 Services

- **API Gateway** — Central entry point for all requests
- **User Service** — Handles user data
- **Payment Service** — Processes payments (Card, UPI, Wallet)
- **Transaction Service** — Tracks transactions, uses Redis
- **Notification Service** — Sends email/SMS notifications
- **Shared Libraries** — Shared event definitions and resilience configs

---

## 🛠️ Technologies

- Spring Boot
- Spring Cloud Gateway
- Kafka (Event-driven communication)
- PostgreSQL
- Redis
- Docker & Docker Compose
- Kubernetes (K8s)

---

## 🚀 Getting Started

### 🔧 Prerequisites

- Java 17+
- Maven
- Docker
- Kubernetes (Minikube or Docker Desktop)

✍️ Author

Anik Halder
GitHub