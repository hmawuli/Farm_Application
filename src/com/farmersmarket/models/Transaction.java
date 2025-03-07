package com.farmersmarket.models;

public class Transaction {
    private int id;
    private int orderId;
    private String transactionDate;
    private String paymentMethod;

    public Transaction(int id, int orderId, String transactionDate, String paymentMethod) {
        this.id = id;
        this.orderId = orderId;
        this.transactionDate = transactionDate;
        this.paymentMethod = paymentMethod;
    }

    public int getId() {
        return id;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
}
