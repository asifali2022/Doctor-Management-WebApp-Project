# Doctor Management WebApplication

This is a Spring Boot application for managing doctors and patients. The application includes endpoints for CRUD operations and suggestions. It also includes Swagger for API documentation.

## API Endpoints

### Doctors

- **Get All Doctors**
  - **URL:** `http://localhost:8080/myapp/doctors`
  - **Method:** GET
  - **Description:** Retrieves a list of all doctors.

- **Get Doctor by ID**
  - **URL:** `http://localhost:8080/myapp/doctors/{id}`
  - **Method:** GET
  - **Description:** Retrieves a doctor by their ID.

- **Add Doctor**
  - **URL:** `http://localhost:8080/myapp/doctors`
  - **Method:** POST
  - **Description:** Adds a new doctor.

- **Delete Doctor**
  - **URL:** `http://localhost:8080/myapp/doctors/{id}`
  - **Method:** DELETE
  - **Description:** Deletes a doctor by their ID.

### Patients

- **Get All Patients**
  - **URL:** `http://localhost:8080/myapp/patients`
  - **Method:** GET
  - **Description:** Retrieves a list of all patients.

- **Get Patient by ID**
  - **URL:** `http://localhost:8080/myapp/patients/{id}`
  - **Method:** GET
  - **Description:** Retrieves a patient by their ID.

- **Add Patient**
  - **URL:** `http://localhost:8080/myapp/patients`
  - **Method:** POST
  - **Description:** Adds a new patient.

- **Delete Patient**
  - **URL:** `http://localhost:8080/myapp/patients/{id}`
  - **Method:** DELETE
  - **Description:** Deletes a patient by their ID.

- **Suggest Doctors for Patient**
  - **URL:** `http://localhost:8080/myapp/patients/{id}/suggest-doctors`
  - **Method:** GET
  - **Description:** Suggests doctors for a patient based on their ID.

## Swagger API Documentation

Swagger has been implemented to provide interactive API documentation.

- **URL:** `http://localhost:8080/myapp/swagger-ui.html`
- **Description:** Access the Swagger UI to explore and test the API endpoints interactively.

## Configuration

The context path for the application is set to `/myapp` in the `application.properties` file:

## Running the Application

1. Ensure you have Java and Maven installed.
2. Navigate to the project directory.
3. Run the application using Maven:
4. Access the application at `http://localhost:8080/myapp`.



