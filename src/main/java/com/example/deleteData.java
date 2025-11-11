package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class deleteData {
    public static void main(String[] args) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM students WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 2);
            stmt.executeUpdate();
            System.out.println("✅ Record deleted!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
