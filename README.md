# Parking Management System (Java AWT)

A simple **GUI-based Parking Management System** developed using **Java AWT**.
This application simulates real-world parking allocation using core **data structures** and **event-driven programming**.

---

## Features

* Park cars into available slots
* Prevent duplicate entries
* Automatic waiting queue when parking is full
* Auto-assign slot when a car leaves
* Remove cars from parking or waiting queue
* Visual representation of parking slots
* Popup window to view waiting queue

---

## Concepts Used

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

## Project Structure

```
ParkingManagementSystem.java
```

---

## ⚙️ How It Works

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

## How to Run

### Step 1: Compile

```
javac ParkingManagementSystem.java
```

### Step 2: Run

```
java ParkingManagementSystem
```

---

## Tech Stack

* Java
* AWT (Abstract Window Toolkit)

---

## UI Preview

* Green → Available Slot
* Red → Occupied Slot
* Yellow → Waiting Queue

---

## Future Improvements

* Upgrade UI using **Java Swing / JavaFX**
* Add **database integration**
* Add **entry/exit timestamps & billing system**
* Convert into a **web-based application**

---

## Learning Outcome

This project helped in understanding:

* Real-world application of data structures
* GUI development in Java
* Event-driven programming
* Problem-solving and system design basics

---

##  Author

**Ganapathi Kushali Kanvitha**

---
