# Hotel Reservation System

## Overview

The Hotel Reservation System is a Java-based console application developed as part of the CodeAlpha Java Programming Internship. The system allows users to view available rooms, book rooms, cancel reservations, search reservations, and manage hotel booking records efficiently.

The project demonstrates Object-Oriented Programming (OOP), File Handling, Collections Framework, Exception Handling, and CRUD operations.

---

# Features

## Room Management

* Display all hotel rooms
* Categorize rooms as:

  * Standard
  * Deluxe
  * Suite
* View room prices
* Track room availability

## Reservation Management

* Book hotel rooms
* Cancel reservations
* View all reservations
* Search reservations by customer name

## Payment Simulation

* Calculate total bill based on room type and duration
* Display booking details
* Generate payment summary

## Data Persistence

* Save reservation records to file
* Load reservation records automatically when program starts

## Validation

* Prevent booking unavailable rooms
* Handle invalid room numbers
* Handle invalid menu selections

---

# Project Structure

CodeAlpha_HotelReservationSystem

├── Room.java

├── Reservation.java

├── HotelReservationSystem.java

├── reservations.txt

└── README.md

---

# OOP Design

## Class: Room

### Attributes

* roomNumber
* roomType
* pricePerNight
* available

### Responsibilities

* Store room information
* Manage room availability

---

## Class: Reservation

### Attributes

* customerName
* room
* numberOfDays
* totalAmount

### Responsibilities

* Store reservation information
* Calculate booking cost
* Generate reservation records

---

## Class: HotelReservationSystem

### Attributes

* ArrayList<Room>
* ArrayList<Reservation>

### Responsibilities

* Manage hotel operations
* Display menu options
* Handle booking and cancellation
* Save and load reservation data

---

# Technologies Used

* Java
* Object-Oriented Programming
* ArrayList
* File Handling
* Exception Handling
* Collections Framework

---

# Future Enhancements

* GUI using Java Swing
* Database Integration (MySQL)
* Online Payment Gateway
* Admin Dashboard
* Customer Login System

---

# Author

Chaithanya Raj Peddireddy

CodeAlpha Java Programming Internship
