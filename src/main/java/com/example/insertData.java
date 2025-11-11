package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
    public static void main(String[] args) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO students (name, age, city) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "Raj");
            stmt.setInt(2, 22);
            stmt.setString(3, "Hyderabad");

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Record inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
