package com.farmersmarket.views;

import com.farmersmarket.models.FarmerProfile;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class FarmerProfileView {
    private VBox view;

    public FarmerProfileView(FarmerProfile farmerProfile) {
        view = new VBox(10);
        view.setPadding(new Insets(20));

        TextField idField = new TextField(String.valueOf(farmerProfile.getId()));
        idField.setPromptText("ID");
        TextField nameField = new TextField(farmerProfile.getName());
        nameField.setPromptText("Name");
        TextField locationField = new TextField(farmerProfile.getLocation());
        locationField.setPromptText("Location");
        TextField contactField = new TextField(farmerProfile.getContact());
        contactField.setPromptText("Contact");

        view.getChildren().addAll(new Label("Farmer Profile Details"), idField, nameField, locationField, contactField);
    }

    public VBox getView() {
        return view;
    }
}
