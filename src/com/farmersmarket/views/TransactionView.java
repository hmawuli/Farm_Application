package com.farmersmarket.views;

import com.farmersmarket.models.Transaction;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class TransactionView {
    private VBox view;

    public TransactionView(Transaction transaction) {
        view = new VBox(10);
        view.setPadding(new Insets(20));

        TextField idField = new TextField(String.valueOf(transaction.getId()));
        idField.setPromptText("ID");
        TextField orderIdField = new TextField(String.valueOf(transaction.getOrderId()));
        orderIdField.setPromptText("Order ID");
        TextField transactionDateField = new TextField(transaction.getTransactionDate());
        transactionDateField.setPromptText("Transaction Date");
        TextField paymentMethodField = new TextField(transaction.getPaymentMethod());
        paymentMethodField.setPromptText("Payment Method");

        view.getChildren().addAll(new Label("Transaction Details"), idField, orderIdField, transactionDateField, paymentMethodField);
    }

    public VBox getView() {
        return view;
    }
}
