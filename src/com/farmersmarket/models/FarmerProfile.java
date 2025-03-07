package com.farmersmarket.models;

public class FarmerProfile {
    private int id;
    private String name;
    private String location;
    private String contact;

    public FarmerProfile(int id, String name, String location, String contact) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getContact() {
        return contact;
    }
}
