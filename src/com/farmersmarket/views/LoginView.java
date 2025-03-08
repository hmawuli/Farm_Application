package com.farmersmarket.views;
import com.farmersmarket.controllers.AuthController;
import com.farmersmarket.models.User;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
public class LoginView {

    private VBox view;

    public LoginView() {
        view = new VBox(10);
        view.setPadding(new Insets(20));

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        Button loginButton = new Button("Login");
        Button registerButton = new Button("Register");

        AuthController authController = new AuthController();
        loginButton.setOnAction(e -> {
            if (authController.login(usernameField.getText(), passwordField.getText())) {
                showAlert("Success", "Login successful!");
            } else {
                showAlert("Failed", "Invalid credentials.");
            }
        });

        registerButton.setOnAction(e -> {
            User newUser = new User(usernameField.getText(), passwordField.getText());
            if (authController.register(newUser)) {
                showAlert("Success", "Registration successful!");
            } else {
                showAlert("Failed", "Registration failed.");
            }
        });

        view.getChildren().addAll(new Label("Login to Farmers' Market"), usernameField, passwordField, loginButton, registerButton);
    }

    public VBox getView() {
        return view;
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void setView(VBox view) {
        this.view = view;
    }
}
