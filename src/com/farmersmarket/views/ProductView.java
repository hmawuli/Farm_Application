package com.farmersmarket.views;

import com.farmersmarket.models.Product;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class ProductView {
    private VBox view;

    public ProductView(Product product) {
        view = new VBox(10);
        view.setPadding(new Insets(20));

        TextField idField = new TextField(String.valueOf(product.getId()));
        idField.setPromptText("ID");
        TextField nameField = new TextField(product.getName());
        nameField.setPromptText("Name");
        TextField priceField = new TextField(String.valueOf(product.getPrice()));
        priceField.setPromptText("Price");
        TextField stockField = new TextField(String.valueOf(product.getStock()));
        stockField.setPromptText("Stock");

        view.getChildren().addAll(new Label("Product Details"), idField, nameField, priceField, stockField);
    }

    public VBox getView() {
        return view;
    }
}
