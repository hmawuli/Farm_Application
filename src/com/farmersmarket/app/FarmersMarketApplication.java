package com.farmersmarket.app;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.farmersmarket.views.LoginView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FarmersMarketApplication extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        initializeDatabase();
        LoginView loginView = new LoginView();
        Scene scene = new Scene(loginView.getView(), 800, 600);
        primaryStage.setTitle("Farmers' Market Management");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initializeDatabase() {
        String url = "jdbc:postgresql://localhost:5432/farmers_market"; // Update with your PostgreSQL database URL
        String user = "postgres"; // Update with your PostgreSQL username
        String password = "alicemawuli@2022"; // Update with your PostgreSQL password

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("A connection to the database has been established.");
            }
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
    }

    public boolean insertUser(String username, String password) {
        if (userExists(username)) {
            System.out.println("Registration failed: User already exists.");
            return false;
        }

        String sql = "INSERT INTO users(username, password) VALUES(?, ?)";
        
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/farmers_market", "postgres", "alicemawuli@2022");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            System.out.println("User information has been inserted.");
            return true;
        } catch (SQLException e) {
            System.out.println("Registration failed: " + e.getMessage());
            return false;
        }
    }

    private boolean userExists(String username) {
        String sql = "SELECT username FROM users WHERE username = ?";
        
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/farmers_market", "postgres", "alicemawuli@2022");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("User existence check failed: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
