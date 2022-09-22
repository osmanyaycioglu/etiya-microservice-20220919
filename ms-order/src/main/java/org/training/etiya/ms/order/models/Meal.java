package org.training.etiya.ms.order.models;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

public class Meal {
    private String name;
    private Float amount;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
