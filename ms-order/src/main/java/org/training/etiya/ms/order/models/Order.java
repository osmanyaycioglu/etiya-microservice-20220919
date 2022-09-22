package org.training.etiya.ms.order.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.training.etiya.ms.order.rest.models.MealRest;

import java.util.List;

public class Order {
    private Long orderId;
    private Long customerId;
    private String customerName;
    private String customerNumber;
    private List<Meal> meals;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
