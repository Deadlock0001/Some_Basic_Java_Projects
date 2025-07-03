# 🏦 Banking Management System

A simple console-based **Banking Management System** built using **Java** and **MySQL** with **JDBC**. It allows users to register, login, manage bank accounts, and perform secure transactions.

---

## 🚀 Features

- 🔐 User Registration and Login
- 🏦 Bank Account Creation
- 💰 Check Balance
- ➕ Credit Money
- ➖ Debit Money
- 🔄 Transfer Funds Between Accounts
- 📦 Modular Structure (User, Account, Transaction classes)

---

## 🧑‍💻 Technologies Used

| Technology     | Purpose                          |
|----------------|----------------------------------|
| Java           | Core programming language        |
| JDBC           | Database connectivity            |
| MySQL          | Backend relational database      |
| Console Input  | User interaction via `Scanner`   |

---

## 🗃️ Database Structure

Make sure your MySQL database (`banking_system`) has the following tables:

### `user` table
```sql
CREATE TABLE user (
    full_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL PRIMARY KEY,
    password VARCHAR(255) NOT NULL
);
```

### `accounts` table
```sql
CREATE TABLE accounts (
    account_number BIGINT NOT NULL PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    balance DECIMAL(10, 2) NOT NULL,
    security_pin CHAR(4) NOT NULL
);
```

---

## 🛠️ Setup Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/banking-management-system.git
   cd banking-management-system
   ```

2. **Configure the database**
   - Create a MySQL database named `banking_system`.
   - Create the required tables (`user`, `accounts`).
   - Update the DB credentials in `BankingSystem.java`:
     ```java
     private static final String url = "jdbc:mysql://localhost:3306/banking_system";
     private static final String Username = "root";
     private static final String Password = "your_password";
     ```

3. **Compile and run**
   ```bash
   javac Bankingmanagment/*.java
   java Bankingmanagment.BankingSystem
   ```

---

## 📁 Project Structure

```
Bankingmanagment/
│
├── BankingSystem.java         # Main entry point
├── User.java                  # Handles registration & login
├── Accounts.java              # Account creation & lookup
└── TransactionManager.java    # Credit, debit, transfer logic
```

---

## ✅ To Do / Improvements

- Hash passwords for better security.
- Add admin features.
- Switch to GUI using JavaFX or Swing.
- Add transaction history tracking.
- Migrate to Spring Boot with REST API.

---

## 📸 Screenshots

![image](https://github.com/user-attachments/assets/06b86c00-4691-4da2-b26f-bed896161f75)
![image](https://github.com/user-attachments/assets/f1ccda2b-ecc1-412b-9b86-b100d2127608)
![image](https://github.com/user-attachments/assets/c649e5af-3e0a-4b13-8087-0f005fe1920d)


---

## 📄 License

This project is open-source and available to all

---

## 🤝 Contributing

Pull requests and contributions are welcome!

---

## ✉️ Contact

For any queries, contact: bariq.imtiyaz@gmail.com
