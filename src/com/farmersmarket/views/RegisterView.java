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

public class RegisterView {

    private VBox view;

    public RegisterView() {
        view = new VBox(10);
        view.setPadding(new Insets(20));

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        Button registerButton = new Button("Register");

        AuthController authController = new AuthController();
        registerButton.setOnAction(e -> {
            User newUser = new User(usernameField.getText(), passwordField.getText());
            if (authController.register(newUser)) {
                showAlert("Success", "Registration successful!");
            } else {
                showAlert("Failed", "Registration failed.");
            }
        });

        view.getChildren().addAll(new Label("Register for Farmers' Market"), usernameField, passwordField, registerButton);
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
}
