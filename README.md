# SmartCampus

SmartCampus is a student academic portal project with a React/Vite frontend and a Spring Boot academic-record API. The repository also includes an unfinished user-service scaffold.

## Project layout

- `academic-service/academic-service`: Spring Boot academic API and local H2 persistence.
- `academic-service/academic-service/frontend`: React and Vite student portal.
- `user-service/user-service`: Gradle Spring Boot scaffold; it is not currently integrated with the portal and does not yet expose user or authentication APIs.

## Run the academic API

From `academic-service/academic-service`, run `./mvnw spring-boot:run` on macOS/Linux or `mvnw.cmd spring-boot:run` on Windows. The service listens on port 8081. Its H2 database is created under `data/` and is intentionally ignored by Git; the application seeds demonstration records when the respective tables are empty.

## Run the frontend

From `academic-service/academic-service/frontend`, run `npm ci` and then `npm run dev`. The frontend defaults to `http://localhost:8081/api`; set `VITE_API_URL` to change the API base URL.

The student sign-in is demonstration-only: it stores a student ID in browser local storage and does not verify a password. Do not use it with real student records.

## User-service configuration

The user-service datasource uses `SMARTCAMPUS_DB_URL`, `SMARTCAMPUS_DB_USERNAME`, and `SMARTCAMPUS_DB_PASSWORD` environment variables. The service is currently a scaffold and is not connected to the academic API or frontend.

## Development notes

Local database files, environment files, IDE metadata, dependency folders, and build outputs are excluded from version control. Configure secrets through environment variables and never commit credentials or real student data.
