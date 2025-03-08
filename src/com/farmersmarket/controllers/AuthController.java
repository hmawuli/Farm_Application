package com.farmersmarket.controllers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.farmersmarket.database.DatabaseConnection;
import com.farmersmarket.models.User;

import javafx.scene.control.Alert;

public class AuthController {

    public boolean login(String username, String password) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE username=? AND password=?")) {

            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return true;
            } else {
                showAlert("Login Failed", "Invalid username or password.");
                return false;
            }
        } catch (Exception e) {
            showAlert("Login Failed", "Error: " + e.getMessage());
            // Log the exception
            System.err.println("Error: " + e.getMessage());
            return false;
        }
    }

    public boolean register(User user) {
        if (userExists(user.getUsername())) {
            showAlert("Registration Failed", "User already exists.");
            return false;
        }

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)")) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            showAlert("Registration Failed", "Error: " + e.getMessage());
            System.err.println("Error: " + e.getMessage());
            return false;
        }
    }

    private boolean userExists(String username) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT username FROM users WHERE username = ?")) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (Exception e) {
            showAlert("Error", "Error checking user existence: " + e.getMessage());
            System.err.println("Error: " + e.getMessage());
            return false;
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
