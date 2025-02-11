# **Pharmacy Management System** 🏥💊

## **Overview**
The **Pharmacy Management System** is a **Java-based** application designed to streamline pharmacy operations, including medicine inventory management, customer tracking, and transaction processing. The system supports **adding, searching, updating, and removing medicines and customers**, as well as **processing sales and generating invoices**.

## **Features**
👉 **Customer Management** 🤓  
   - Add, list, search, and remove customers.  
   - Maintain customer purchase history.  

👉 **Medicine Management** 💊  
   - Add, list, search, and remove medicines.  
   - Track stock levels and update inventory.  
   - Categorize medicines by **ID, name, type, expiry date**.  

👉 **Transaction Processing** 💰  
   - Handle **sales and purchases** efficiently.  
   - **Generate invoices** for customers.  
   - Track purchase history.  

👉 **Database Integration** 📂  
   - **Persistent data storage** using **MySQL**.  
   - Track **medicine stock updates** in real-time.  

👉 **Admin Controls** 🔒  
   - **Add or block users** (Admins only).  
   - Update **medicine stock levels**.  
   - Secure **login system** (future update).  

## **Technologies Used**
- **Programming Language:** Java ☕  
- **Database:** MySQL 📂  
- **Libraries:** JDBC for database connectivity  

---

## **Main Classes and Their Roles**

### 📌 **1. PharmacyManagementSystem (Main Class)**
- **Entry point** of the application.  
- Provides **main menu interface** for all system operations.  

### 📌 **2. Customer**
- Represents **customers** in the system.  
- **Fields:** `customerId`, `name`, `contactInfo`.  
- **Methods:**  
  - `getCustomerId()`, `getName()`, `getContactInfo()`.  
  - `purchaseMedicine()` - Allows customers to buy medicines.  

### 📌 **3. Medicine**
- Represents **medicine inventory**.  
- **Fields:** `medicineId`, `name`, `type`, `expiryDate`, `price`, `stockQuantity`.  
- **Methods:**  
  - `getMedicineId()`, `getName()`, `getType()`.  
  - `getExpiryDate()`, `getPrice()`, `getStockQuantity()`.  

### 📌 **4. CustomerService**
- Handles **customer-related operations**.  
- **Methods:**  
  - `addCustomer(Customer customer)`, `removeCustomer(String customerId)`.  
  - `findCustomerById(String customerId)`, `listAllCustomers()`.  

### 📌 **5. MedicineService**
- Handles **medicine-related operations**.  
- **Methods:**  
  - `addMedicine(Medicine medicine)`, `removeMedicine(String medicineId)`.  
  - `findMedicineById(String medicineId)`, `listAllMedicines()`.  
  - `updateStock(String medicineId, int newQuantity)`.  

### 📌 **6. TransactionService**
- Manages **pharmacy transactions**.  
- **Methods:**  
  - `processSale(String customerId, String medicineId, int quantity)`.  
  - `generateInvoice(String customerId)`.  

### 📌 **7. DatabaseHandler**
- Manages **database connections and queries**.  
- **Methods:**  
  - `getConnection()`, `getMedicineStock(String medicineId)`.  
  - `updateStock(String medicineId, int quantity)`.  

---

## **How to Run**
### **1️⃣ Set Up the Database**
Ensure you have **MySQL installed** and run the following:
```sql
CREATE DATABASE pharmacy;
USE pharmacy;

CREATE TABLE Medicines (
    medicine_id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255),
    type VARCHAR(255),
    expiry_date DATE,
    price DECIMAL(10,2),
    stock_quantity INT DEFAULT 0
);

CREATE TABLE Customers (
    customer_id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255),
    contact_info VARCHAR(255)
);
```

### **2️⃣ Configure Database Connection**
Update database credentials in **`DatabaseHandler.java`**:
```java
connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "your_username", "your_password");
```

### **3️⃣ Compile and Run the Program**
Open a terminal and run:
```sh
javac *.java
java PharmacyManagementSystem
```

### **4️⃣ Test the Features**
- Add medicines and customers.
- Search for medicines by **name, batch number, or category**.
- Process sales and update inventory.
- Generate invoices for customers.
- Update stock levels dynamically.

---

## **Future Enhancements 🚀**
🔹 **User authentication system** (Admin vs Customer)  
🔹 **Graphical User Interface (GUI)** for better usability  
🔹 **Reporting module** (daily sales, low-stock alerts)  
🔹 **Export invoices to PDF**  

---

### **👨‍💻 Contributors**
- **GitHub:** [Your GitHub Profile](https://github.com/smnxie)  
- **Project Repository:** [Pharmacy Management System](https://github.com/smnxie/pharmacy-java)  

---

### **📝 License**
This project is open-source and available under the **MIT License**.

---

## **📢 Final Thoughts**
This **Pharmacy Management System** is designed to improve efficiency in managing a pharmacy’s daily operations. It offers a **robust inventory tracking system, customer management, and transaction processing** in an easy-to-use interface.

🔥 **Contributions and feature suggestions are welcome!** 🔥


