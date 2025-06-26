# 📚 Java Library Management System

A simple command-line-based **Library Management System** in Java that allows users to:

- Add books
- View available books
- Issue books
- Return books

This is a beginner-friendly Java project demonstrating object-oriented programming, arrays, and basic input handling using `Scanner`.

---

## 💡 Features

- Add up to 5 books to the system
- View list of available books
- Issue a book (mark as issued)
- Return a book (mark as available)
- Menu-driven console interface

---

## 🛠️ Technologies Used

- Java (JDK 8+)
- Command-line interface (CLI)
- Scanner for input handling

---

## 🧾 How It Works

1. On running the program, the user is prompted to enter 5 book names.
2. The system presents a menu:
   - Show available books
   - Issue a book
   - Return a book
   - Exit
3. Issuing a book marks it as unavailable.
4. Returning a book marks it as available again.

---

## 📦 Project Structure

```plaintext
Librarybook.java   // Class with methods to manage books
library.java       // Main class with menu-driven logic
