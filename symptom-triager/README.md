# Symptom Triager

A Spring Boot web application for symptom-based disease triaging. Users can input symptoms and get possible disease suggestions from a MySQL database.

## Features

- **Symptom Input**: Users can enter multiple symptoms separated by commas
- **Disease Matching**: System searches for diseases that match any of the entered symptoms
- **Admin Panel**: CRUD operations for managing diseases and their symptoms
- **Responsive UI**: Bootstrap-based responsive design

## Tech Stack

- Java 17
- Spring Boot 3.2.0
- Spring Web
- Spring Data JPA
- MySQL Database
- Thymeleaf (Frontend)
- Maven
- Lombok
- Bootstrap 5

## Database Schema

### Disease Table
- `id` (Primary Key, Auto Increment)
- `name` (VARCHAR) - Disease name
- `symptoms` (TEXT) - Comma-separated symptoms
- `description` (TEXT) - Disease description

## Setup Instructions

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- MySQL 8.0+

### Database Setup
1. Install MySQL and start the service
2. Create a database named `symptom_db`:
   ```sql
   CREATE DATABASE symptom_db;
   ```
3. Update `src/main/resources/application.properties` with your MySQL credentials:
   ```properties
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

### Running the Application

1. Clone or download the project
2. Navigate to the project directory:
   ```bash
   cd symptom-triager
   ```
3. Build the project:
   ```bash
   mvn clean install
   ```
4. Run the application:
   ```bash
   mvn spring-boot:run
   ```
5. Open your browser and go to: `http://localhost:8080`

## Usage

### For Users
1. Go to the home page (`/`)
2. Enter symptoms separated by commas (e.g., "fever, cough, headache")
3. Click "Check Symptoms" to see matching diseases
4. View results with disease names, symptoms, and descriptions

### For Admins
1. Go to the admin panel (`/admin`)
2. Add new diseases with their symptoms and descriptions
3. Edit existing diseases
4. Delete diseases as needed

## API Endpoints

- `GET /` - Home page with symptom input form
- `POST /check` - Process symptom input and show results
- `GET /admin` - Admin panel for disease management
- `POST /admin/add` - Add new disease
- `POST /admin/update` - Update existing disease
- `POST /admin/delete/{id}` - Delete disease
- `GET /admin/edit/{id}` - Edit disease form

## Sample Data

You can add sample diseases through the admin panel:

1. **Common Cold**
   - Symptoms: runny nose, sneezing, cough, sore throat
   - Description: A viral infection of the upper respiratory tract

2. **Flu**
   - Symptoms: fever, body aches, fatigue, cough, headache
   - Description: Influenza is a viral infection that attacks the respiratory system

3. **Migraine**
   - Symptoms: severe headache, nausea, sensitivity to light
   - Description: A type of headache characterized by severe pain

## Project Structure

```
src/
├── main/
│   ├── java/com/symptomtriager/
│   │   ├── controller/
│   │   │   └── DiseaseController.java
│   │   ├── model/
│   │   │   └── Disease.java
│   │   ├── repository/
│   │   │   └── DiseaseRepository.java
│   │   ├── service/
│   │   │   └── DiseaseService.java
│   │   └── SymptomTriagerApplication.java
│   └── resources/
│       ├── templates/
│       │   ├── index.html
│       │   ├── results.html
│       │   └── admin.html
│       └── application.properties
└── pom.xml
```

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test thoroughly
5. Submit a pull request

## License

This project is open source and available under the MIT License.