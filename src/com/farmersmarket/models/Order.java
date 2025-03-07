package com.farmersmarket.models;

public class Order {
    private int id;
    private String orderNumber;
    private double amount;
    private int userId;
    private String status;

    public Order(int id, String orderNumber, double amount, int userId, String status) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.amount = amount;
        this.userId = userId;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public double getAmount() {
        return amount;
    }

    public int getUserId() {
        return userId;
    }

    public String getStatus() {
        return status;
    }
}
