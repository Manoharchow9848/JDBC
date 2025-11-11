
# ☕ Java JDBC (Java Database Connectivity) — Complete Guide

This guide explains everything you need to know about **JDBC in Java**, including how to connect to a **MySQL database**, perform **CRUD (Create, Read, Update, Delete)** operations, and best practices — all with **detailed examples**.

---

## 🧩 1️⃣ What is JDBC?

**JDBC (Java Database Connectivity)** is an API in Java that allows applications to connect and interact with databases using SQL.

---

## 🧠 2️⃣ JDBC Architecture

### ✅ JDBC Components:
1. **DriverManager** — Manages database drivers and connections.
2. **Connection** — Represents a connection to the database.
3. **Statement / PreparedStatement** — Executes SQL queries.
4. **ResultSet** — Stores the result of a query.
5. **SQLException** — Handles database access errors.

---

## ⚙️ 3️⃣ Steps to Use JDBC

| Step | Description |
|------|--------------|
| 1️⃣ | Load the JDBC driver (optional in modern Java) |
| 2️⃣ | Establish a connection using `DriverManager` |
| 3️⃣ | Create a `Statement` or `PreparedStatement` |
| 4️⃣ | Execute SQL queries |
| 5️⃣ | Process the results using `ResultSet` |
| 6️⃣ | Close all connections |

---

## 🧩 4️⃣ MySQL Setup

### Create Database and Table:

```sql
CREATE DATABASE studentdb;
USE studentdb;

CREATE TABLE students (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50),
  age INT,
  city VARCHAR(50)
);
```

✅ Database: `studentdb`  
✅ Table: `students`

---

## 🧩 5️⃣ Add MySQL JDBC Driver

### Option 1: Using Maven
Add this dependency in your `pom.xml`:
```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.0.33</version>
</dependency>
```

### Option 2: Without Maven
1. Download MySQL Connector JAR from: [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/)
2. In IntelliJ → `File → Project Structure → Libraries → + → Java` → select `.jar` file.

---

## 🧩 6️⃣ Establish Database Connection

```java
package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Connected to Database Successfully!");
        } catch (SQLException e) {
            System.out.println("❌ Connection Failed!");
            e.printStackTrace();
        }
        return conn;
    }
}
```

---

## 🧩 7️⃣ Insert Data (CREATE Operation)

```java
package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertData {
    public static void main(String[] args) {
        String sql = "INSERT INTO students (name, age, city) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "Raj");
            stmt.setInt(2, 22);
            stmt.setString(3, "Hyderabad");

            int rows = stmt.executeUpdate();
            System.out.println(rows + " record(s) inserted.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### 🧠 Output:
```
✅ Connected to Database Successfully!
1 record(s) inserted.
```

---

## 🧩 8️⃣ Read Data (SELECT Operation)

```java
package com.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadData {
    public static void main(String[] args) {
        String sql = "SELECT * FROM students";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String city = rs.getString("city");

                System.out.println(id + " | " + name + " | " + age + " | " + city);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### 🧠 Output:
```
✅ Connected to Database Successfully!
1 | Raj | 22 | Hyderabad
```

---

## 🧩 9️⃣ Update Data (UPDATE Operation)

```java
package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateData {
    public static void main(String[] args) {
        String sql = "UPDATE students SET city = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "Delhi");
            stmt.setInt(2, 1);

            int rows = stmt.executeUpdate();
            System.out.println(rows + " record(s) updated.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### 🧠 Output:
```
✅ Connected to Database Successfully!
1 record(s) updated.
```

---

## 🧩 🔟 Delete Data (DELETE Operation)

```java
package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteData {
    public static void main(String[] args) {
        String sql = "DELETE FROM students WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, 1);
            int rows = stmt.executeUpdate();
            System.out.println(rows + " record(s) deleted.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### 🧠 Output:
```
✅ Connected to Database Successfully!
1 record(s) deleted.
```

---

## ✅ Summary

This example covered how to perform **CRUD operations** using **JDBC** in **Java with MySQL** in IntelliJ IDEA, including connection setup, dependency management, and proper use of `PreparedStatement`.

---
