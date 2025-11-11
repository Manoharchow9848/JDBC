package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class upDateData {
    public static void main(String[] args){
        try(Connection conn = DBConnection.getConnection()){
            String sql = "UPDATE students SET city = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "Delhi");
            stmt.setInt(2, 2);
            stmt.executeUpdate();
            System.out.println("✅ Record updated!");

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
