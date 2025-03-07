package com.farmersmarket.views;

import com.farmersmarket.models.User;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class UserView {
    private VBox view;

    public UserView(User user) {
        view = new VBox(10);
        view.setPadding(new Insets(20));

        TextField usernameField = new TextField(user.getUsername());
        usernameField.setPromptText("Username");
        PasswordField passwordField = new PasswordField();
        passwordField.setText(user.getPassword());
        passwordField.setPromptText("Password");

        view.getChildren().addAll(new Label("User Details"), usernameField, passwordField);
    }

    public VBox getView() {
        return view;
    }
}
