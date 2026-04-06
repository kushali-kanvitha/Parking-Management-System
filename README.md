# Parking Management System (Java AWT)

A simple **GUI-based Parking Management System** developed using **Java AWT**.
This application simulates real-world parking allocation using core **data structures** and **event-driven programming**.

---

## Features:

* Park cars into available slots
* Prevent duplicate entries
* Automatic waiting queue when parking is full
* Auto-assign slot when a car leaves
* Remove cars from parking or waiting queue
* Visual representation of parking slots
* Popup window to view waiting queue

---

## Concepts Used:

* **Object-Oriented Programming (OOP)**
* **Java AWT (GUI)**

  * Frame, Panel, Canvas, Dialog
* **Event Handling**

  * ActionListener
* **Data Structures**

  * ArrayList → Parking Slots
  * Queue (LinkedList) → Waiting Queue
* **Graphics Rendering**

  * Custom UI using `paint()` method

---

## Project Structure:

```
ParkingManagementSystem.java
```

---

## How It Works:

1. User enters a car number
2. Click **"Park Car"**

   * If slot available → car is parked
   * If full → car goes to waiting queue
3. Click **"Remove Car"**

   * Car removed from slot
   * First waiting car gets allocated automatically
4. Click **"Waiting List"**

   * Displays all queued cars
---

## Tech Stack:

* Java
* AWT (Abstract Window Toolkit)

---

## UI Preview:

* Green → Available Slot
* Red → Occupied Slot
* Yellow → Waiting Queue

---

## Future Improvements:

* Upgrade UI using **Java Swing / JavaFX**
* Add **database integration**
* Add **entry/exit timestamps & billing system**
* Convert into a **web-based application**

---
## Screenshot:
<img width="1919" height="635" alt="Screenshot 2026-04-06 160525" src="https://github.com/user-attachments/assets/1cd2bd6a-1f07-4511-a510-b4f8c0a0f25c" />
<img width="1919" height="601" alt="Screenshot 2026-04-06 160604" src="https://github.com/user-attachments/assets/4ee9f68c-4b9e-4518-9431-8c7e9f7b98c9" />


## Learning Outcome:

This project helped in understanding:

* Real-world application of data structures
* GUI development in Java
* Event-driven programming
* Problem-solving and system design basics

---

##  Author:

**Ganapathi Kushali Kanvitha**

---
