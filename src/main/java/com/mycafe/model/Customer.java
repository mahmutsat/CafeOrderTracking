package com.mycafe.model;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@ApiModel(value = "Müşteri Tablosu")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String customerName;

    @OneToMany
    private List<FoodOrder> orders;

    @Column
    private boolean isActive;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName.toUpperCase();
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<FoodOrder> getOrders() { return orders; }

    public void setOrders(List<FoodOrder> orders) { this.orders = orders; }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
