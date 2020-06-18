package com.mycafe.service;

import com.mycafe.dao.FoodOrderDAO;
import com.mycafe.model.Customer;
import com.mycafe.model.Foods;
import com.mycafe.model.FoodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FoodOrderServiceImpl implements FoodOrderService {
    @Autowired
    @Qualifier("getOrderDao")
    private FoodOrderDAO orderDAOImpl;

    @Override
    public void insertOrder(Foods food, Customer customer) {
        orderDAOImpl.insertOrder(food, customer);
    }

    @Override
    public List<FoodOrder> getOrderList() {
        return orderDAOImpl.getOrderList();
    }

    @Override
    public void removeAllOrders() {
        orderDAOImpl.removeAllOrders();
    }

    public Map<Customer, List<FoodOrder>> getOrdersWithPlacedType(boolean isPlaced) { return orderDAOImpl.getOrdersWithPlacedType(isPlaced); }
}
