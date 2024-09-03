/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.*;

public class UserDAO {
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/registration";
    private String user = "root";
    private String password = "";
    
    //Database connection
    public UserDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Registration method
    public boolean registerUser(User user) {
        try {
            String query = "INSERT INTO users (full_name, username, password, phone) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, user.getFullName());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getPhone());

            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean authenticateUser(String username, String hashedPassword) {
        try {
            String query = "SELECT password FROM users WHERE username = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String storedHashedPassword = rs.getString("password");
                // Compara el hash de la contraseña ingresada con el hash almacenado
                return storedHashedPassword.equals(hashedPassword);
            } else {
                return false; // Usuario no encontrado
            }
        } catch (SQLException e) {
            e.printStackTrace();
        return false;
        }
    }

}


