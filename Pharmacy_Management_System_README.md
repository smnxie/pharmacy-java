# Pharmacy Management System

## Overview

The **Pharmacy Management System** is a Java-based application designed to streamline the management of medicines, customers, and pharmacy operations. This system supports adding and managing medicines, customers, and transactions while providing administrative controls for enhanced functionality.

## Features

- **Customer Management:**
  - Add, list, and find customers.
  - Maintain customer purchase history.
  
- **Medicine Management:**
  - Add, list, and search for medicines.
  - Categorize medicines by ID, name, type, and expiry date.

- **Transaction Processing:**
  - Handle sales and purchases.
  - Generate invoices for customers.
  
- **Database Integration:**
  - Persistent data storage using MySQL for managing medicine inventory and customer records.

## Technologies Used

- **Programming Language:** Java
- **Database:** MySQL
- **Libraries:** JDBC for database connectivity

## Main Classes and Their Roles

### 1. **PharmacyManagementSystem**
The entry point of the application. It provides the main menu interface and handles user input for pharmacy operations.

### 2. **Customer**
Represents a customer in the system.
- **Fields:** `customerId`, `name`, `contactInfo`
- **Methods:**
  - `getCustomerId()`
  - `getName()`
  - `getContactInfo()`
  - `purchaseMedicine()`

### 3. **Medicine**
Represents a medicine in the inventory.
- **Fields:** `medicineId`, `name`, `type`, `expiryDate`, `price`
- **Methods:**
  - `getMedicineId()`
  - `getName()`
  - `getType()`
  - `getExpiryDate()`
  - `getPrice()`

### 4. **CustomerService**
Handles customer-related operations.
- **Methods:**
  - `addCustomer(Customer customer)`
  - `removeCustomer(String customerId)`
  - `findCustomerById(String customerId)`
  - `listAllCustomers()`

### 5. **MedicineService**
Handles medicine-related operations.
- **Methods:**
  - `addMedicine(Medicine medicine)`
  - `removeMedicine(String medicineId)`
  - `findMedicineById(String medicineId)`
  - `listAllMedicines()`

### 6. **TransactionService**
Handles pharmacy transactions.
- **Methods:**
  - `processSale(String customerId, String medicineId, int quantity)`
  - `generateInvoice(String customerId)`

### 7. **DatabaseHandler**
Manages database connections and operations.
- **Methods:**
  - `getConnection()`
  - `getMedicineStock(String medicineId)`
  - `updateStock(String medicineId, int quantity)`

## How to Run

1. Ensure you have Java and MySQL installed on your system.
2. Set up the database:
   - Create a database named `pharmacy`.
   - Use the following command to create the `Medicines` table:
     ```sql
     CREATE TABLE Medicines (
       medicine_id VARCHAR(255) PRIMARY KEY,
       name VARCHAR(255),
       type VARCHAR(255),
       expiry_date DATE,
       price DECIMAL(10,2)
     );
     ```
3. Update database credentials in `DatabaseHandler`:
   ```java
   connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "your_username", "your_password");
   ```
