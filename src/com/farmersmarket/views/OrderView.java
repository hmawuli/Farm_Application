package com.farmersmarket.views;

import com.farmersmarket.models.Order;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class OrderView {
    private VBox view;

    public OrderView(Order order) {
        view = new VBox(10);
        view.setPadding(new Insets(20));

        TextField idField = new TextField(String.valueOf(order.getId()));
        idField.setPromptText("ID");
        TextField orderNumberField = new TextField(order.getOrderNumber());
        orderNumberField.setPromptText("Order Number");
        TextField amountField = new TextField(String.valueOf(order.getAmount()));
        amountField.setPromptText("Amount");
        TextField userIdField = new TextField(String.valueOf(order.getUserId()));
        userIdField.setPromptText("User ID");
        TextField statusField = new TextField(order.getStatus());
        statusField.setPromptText("Status");

        view.getChildren().addAll(new Label("Order Details"), idField, orderNumberField, amountField, userIdField, statusField);
    }

    public VBox getView() {
        return view;
    }
}
