package com.mycafe.model;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@ApiModel(value = "Onaylanmış Siparişlerin Tablosu")
public class PlacedOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private Customer customer;

    @ManyToMany
    private List<FoodOrder> foodOrders;

    @Column
    private String orderDescription;

    @Column
    private String waiterNameTookTheOrder;

    @Column
    private boolean isWaiterTakeTheOrder;

    @Column
    private boolean isDelivered;

    @Column
    private String tableNo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<FoodOrder> getFoodOrders() {
        return foodOrders;
    }

    public void setFoodOrders(List<FoodOrder> customers) {
        this.foodOrders = customers;
    }

    public Customer getCustomer() { return customer; }

    public void setCustomer(Customer customer) { this.customer = customer; }

    public String getOrderDescription() { return orderDescription; }

    public void setOrderDescription(String orderDescription) { this.orderDescription = orderDescription; }

    public boolean isWaiterTakeTheOrder() { return isWaiterTakeTheOrder; }

    public void setWaiterTakeTheOrder(boolean waiterTakeTheOrder) { isWaiterTakeTheOrder = waiterTakeTheOrder; }

    public String getWaiterNameTookTheOrder() { return waiterNameTookTheOrder; }

    public void setWaiterNameTookTheOrder(String waiterNameTookTheOrder) { this.waiterNameTookTheOrder = waiterNameTookTheOrder; }

    public boolean isDelivered() { return isDelivered; }

    public void setDelivered(boolean delivered) { isDelivered = delivered; }

    public String getTableNo() { return tableNo; }

    public void setTableNo(String tableNo) { this.tableNo = tableNo; }
}
