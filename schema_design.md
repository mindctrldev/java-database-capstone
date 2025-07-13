## MySQL Database Design

### Table: patients

-id: INT, Primary Key, AutoIncrement
-firstName: varchar(100), NOT NULL
-lastName: varchar(100), NOT NULL
-address: varchar(100), NOT NULL
-email: varchar(100), NOT NULL, UNIQUE
-phone: INT, NOT NULL, UNIQUE

### Table: doctors

-id: INT, Primary Key, AutoIncrement
-firstName: varchar(100), NOT NULL
-lastName: varchar(100), NOT NULL
-address: varchar(100), NOT NULL
-email: varchar(100), NOT NULL, UNIQUE
-phone: INT, NOT NULL, UNIQUE

### Table: appointments

- id: INT, Primary Key, Auto Increment
- doctor_id: INT, Foreign Key → doctors(id)
- patient_id: INT, Foreign Key → patients(id)
- appointment_time: DATETIME, Not Null
- status: INT (0 = Scheduled, 1 = Completed, 2 = Cancelled)

### Table: admin

-id: INT, Primary Key, AutoIncrement
-firstName: varchar(100), NOT NULL
-lastName: varchar(100), NOT NULL
-email: varchar(100), NOT NULL, UNIQUE
-isAdmin: Boolean, NOT NULL

## MongoDB Collection Design

### Collection: prescriptions

```json
{
  "_id": "ObjectId('64abc123456')",
  "patientName": "John Smith",
  "appointmentId": 51,
  "medication": "Paracetamol",
  "dosage": "500mg",
  "doctorNotes": "Take 1 tablet every 6 hours.",
  "refillCount": 2,
  "pharmacy": {
    "name": "Walgreens SF",
    "location": "Market Street"
  }
}
```