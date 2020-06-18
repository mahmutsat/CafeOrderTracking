package com.mycafe.model;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@ApiModel(value = "Verilen Siparişlerin Tablosu")
public class FoodOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @ManyToOne
    private Customer customer;

    @ManyToMany
    private List<Foods> foods = new ArrayList<>();

    private boolean isOrderPlaced;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Foods> getFoods() { return foods; }

    public void setFoods(List<Foods> foods) { this.foods = foods; }

    public boolean isOrderPlaced() { return isOrderPlaced;}

    public void setOrderPlaced(boolean orderPlaced) { isOrderPlaced = orderPlaced; }

    public Customer getCustomer() { return customer; }

    public void setCustomer(Customer customer) { this.customer = customer; }

    @Override
    public String toString() {
        final String[] aaaa = {"FoodOrder{" +
                "id=" + id +
                ", customer=" + customer +
                ", isOrderPlaced=" + isOrderPlaced +
                '}'};

        foods.forEach(foods1 -> {
            aaaa[0] += " " + foods1.getName().toString() + " ";
        });

        return aaaa[0];
    }
}
