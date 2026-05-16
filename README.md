# Notification System

A backend notification system built with Java and Spring Boot for sending emails using SMTP protocol.

## Tech Stack
- Java 17
- Spring Boot 3.5.14
- MySQL
- JavaMail API
- REST API
- Maven

## Features
- Send single email notifications
- Send bulk email notifications
- Log all notifications in MySQL database
- Track delivery status (SENT/FAILED)

## Project Structure
src/
└── main/
└── java/
└── com/aniket/notification_system/
├── controller/
│   └── NotificationController.java
├── model/
│   └── Notification.java
├── repository/
│   └── NotificationRepository.java
└── service/
└── NotificationService.java

## Setup Instructions
1. Clone the repository
2. Create MySQL database:
```sql
CREATE DATABASE notification_db;
```
3. Copy `application.properties.example` to `application.properties`
4. Fill in your MySQL and Gmail credentials
5. Run the application

## API Endpoints

### Send Single Email
POST /api/notifications/send
```json
{
    "toEmail": "example@gmail.com",
    "subject": "Hello!",
    "body": "This is a test email."
}
```

### Send Bulk Emails
POST /api/notifications/send-bulk
```json
{
    "emails": ["email1@gmail.com", "email2@gmail.com"],
    "subject": "Hello!",
    "body": "This is a bulk email."
}
```

### Get All Notifications
GET /api/notifications/all

## Author
Aniket  — [GitHub](https://github.com/AniketKr010)