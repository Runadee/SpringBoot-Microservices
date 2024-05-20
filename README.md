

# SpringBoot Microservices

This repository contains a Spring Boot Microservices project. The application demonstrates a simple microservices architecture using Spring Boot, Spring Cloud, and various other tools and libraries.

## Project Structure

The project is divided into multiple modules:

1. **API Gateway** (`api-gateway`): Serves as the entry point for all client requests, routing them to the appropriate microservices.
2. **Config Server** (`config-server`): Centralized configuration server that manages external configurations for all microservices.
3. **Service Discovery** (`service-discovery`): Manages service registration and discovery, enabling microservices to find and communicate with each other.

## Modules Overview

### API Gateway

The API Gateway handles client requests and routes them to the appropriate microservice. It uses Netflix Zuul for routing and filtering.

### Config Server

The Config Server provides a centralized configuration management solution, allowing microservices to fetch their configurations from a central location. This helps in managing configurations across different environments and improves scalability.

### Service Discovery

Service Discovery uses Netflix Eureka for registering microservices and enabling them to discover each other. This eliminates the need for hard-coded service addresses and improves the resilience and scalability of the architecture.

## Prerequisites

- Java 11 or higher
- Maven 3.6 or higher
- Docker (optional, for containerization)

## Getting Started

1. **Clone the repository:**

   ```sh
   git clone https://github.com/Runadee/SpringBoot-Microservices.git
   cd SpringBoot-Microservices
   ```

2. **Build the project:**

   Navigate to the root directory and run:

   ```sh
   mvn clean install
   ```

3. **Run the Config Server:**

   ```sh
   cd config-server
   mvn spring-boot:run
   ```

4. **Run the Service Discovery:**

   ```sh
   cd service-discovery
   mvn spring-boot:run
   ```

5. **Run the API Gateway:**

   ```sh
   cd api-gateway
   mvn spring-boot:run
   ```

## Configuration

Configurations for the microservices are managed by the Config Server. Update the configuration files in the `config-repo` directory as needed.

## Docker Support

To run the services in Docker containers, you can use the provided Dockerfile in each module directory. Build and run the containers using Docker Compose for easy orchestration.

## Contributing

Contributions are welcome! Please fork the repository and open a pull request with your changes.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

