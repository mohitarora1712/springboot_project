package com.lpu.mob.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class MobileDTO {

    @NotBlank(message = "Brand name is required")
    private String brandName;

    @NotBlank(message = "Model name is required")
    private String modelName;

    @Min(value = 1000, message = "Price must be at least 1000")
    private double price;

    @Min(value = 1, message = "RAM must be at least 1GB")
    private int ram;

    @Min(value = 8, message = "Storage must be at least 8GB")
    private int storage;

    @NotBlank(message = "Color is required")
    private String color;

    public MobileDTO() {}

    // Getters and Setters

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