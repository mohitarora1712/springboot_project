package com.lpu.mob.entity;

import jakarta.persistence.*;

@Entity
public class Mobile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brandName;
    private String modelName;
    private double price;
    private int ram;
    private int storage;
    private String color;

    public Mobile() {}

    // Getters and Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBrandName() { return brandName; }
    public void setBrandName(String brandName) { this.brandName = brandName; }

    public String getModelName() { return modelName; }
    public void setModelName(String modelName) { this.modelName = modelName; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getRam() { return ram; }
    public void setRam(int ram) { this.ram = ram; }

    public int getStorage() { return storage; }
    public void setStorage(int storage) { this.storage = storage; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
}