package com.mycafe.dao;

import com.mycafe.model.Customer;
import com.mycafe.model.Foods;
import com.mycafe.model.FoodOrder;

import java.util.List;
import java.util.Map;

public interface FoodOrderDAO {

    public void insertOrder(Foods food, Customer customer);

    public List<FoodOrder> getOrderList();

    public void removeAllOrders();

    public Map<Customer, List<FoodOrder>> getOrdersWithPlacedType(boolean isPlaced);

    public List<Customer> getCustomersHaveAnOrder();
}
