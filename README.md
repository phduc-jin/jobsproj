# Job Portal

A Java and Spring Boot multi-module backend for a job portal. The repository currently contains a user service for account registration, a shared library for user types and response DTOs, and a placeholder cloud module.

> **Development status:** This project is under active development and is not production-ready. Login is not implemented, the signup response currently contains a placeholder JWT, and passwords are not yet hashed. Do not use real credentials or deploy this service with the sample database settings.

## Project structure

| Module | Purpose |
| --- | --- |
| `common-lib` | Shared user roles, statuses, and response DTOs |
| `services/job-portal-user-service` | User service and current signup endpoint |
| `cloud` | Reserved for cloud components; no application modules are currently configured |

## Technology stack

- Java 21
- Maven multi-module build
- Spring Boot 4.1.2
- Spring MVC and Spring Data JPA
- PostgreSQL
- JJWT dependencies (JWT issuance is not yet implemented)

## Prerequisites

- JDK 21
- Maven 3.9 or later
- Docker with the Compose plugin, for the local PostgreSQL database

Verify the Java and Maven installations:

```bash
java -version
mvn -version
```

## Run locally

1. Start PostgreSQL:

   ```bash
   docker compose up -d db
   ```

   The Compose configuration creates a database named `job_portal` on port `5432`.

2. Build the Maven reactor and run tests:

   ```bash
   mvn clean verify
   ```

3. Start the user service:

   ```bash
   mvn -pl services/job-portal-user-service -am spring-boot:run
   ```

The service listens on `http://localhost:5001`. Its current local database configuration is in [`application.yaml`](services/job-portal-user-service/src/main/resources/application.yaml) and uses the sample `postgres` / `postgres` credentials. Change these settings before using a non-local environment.

Stop the database when finished:

```bash
docker compose down
```

## Current API

### Register a user

```http
POST /auth
Content-Type: application/json
```

Example request:

```json
{
  "fullName": "Alex Nguyen",
  "email": "alex@example.com",
  "password": "replace-with-a-local-test-password",
  "phone": "+1-555-0100",
  "role": "ROLE_JOB_SEEKER"
}
```

Supported roles are `ROLE_JOB_SEEKER` and `ROLE_EMPLOYER`. Self-registration as `ROLE_ADMIN` is rejected. The response includes user details and a placeholder `jwt` value; it must not be treated as an authentication token.

The login request/service types exist, but no login endpoint is currently exposed.

## Configuration and safety

The checked-in database credentials are for local development only. Before deploying:

- Move credentials and signing keys to a secret manager or environment-specific configuration.
- Hash passwords with a suitable password-hashing algorithm.
- Implement and validate JWT issuance and authentication.
- Configure database schema migrations and production-safe JPA settings.

## Contributing

Keep changes focused, add or update tests for behavior changes, and run the reactor checks before submitting:

```bash
mvn clean verify
```
