# Job Application Tracker

A professional full-stack Spring Boot application to manage job applications.

## Features
- Add, edit, delete job applications
- Search by company name or job role
- Pagination support
- Inline status update
- Dashboard with application counts

## Architecture
Controller → Service → Repository (Layered architecture)

## Tech Stack
- Java 17
- Spring Boot 3
- Spring Data JPA
- MySQL
- HTML, CSS, Thymeleaf

## How to Run
1. Create MySQL database `job_tracker_db`
2. Update DB credentials in `application.properties`
3. Run Spring Boot application
4. Open http://localhost:8080
