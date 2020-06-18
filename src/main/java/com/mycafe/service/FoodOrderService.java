package com.mycafe.service;

import com.mycafe.model.Customer;
import com.mycafe.model.Foods;
import com.mycafe.model.FoodOrder;

import java.util.List;
import java.util.Map;

public interface FoodOrderService {

    public void insertOrder(Foods foods, Customer customer);

    public List<FoodOrder> getOrderList();

    public void removeAllOrders();

    public Map<Customer, List<FoodOrder>> getOrdersWithPlacedType(boolean isPlaced);
}
