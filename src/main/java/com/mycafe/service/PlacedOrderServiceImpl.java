package com.mycafe.service;

import com.mycafe.dao.PlacedOrderDAO;
import com.mycafe.model.PlacedOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlacedOrderServiceImpl implements PlacedOrderService {
    @Autowired
    private PlacedOrderDAO placedOrderDAO;

    @Override
    public PlacedOrder getPlacedOrderById(int id) {
        return placedOrderDAO.getPlacedOrderById(id);
    }

    @Override
    public void deletePlacedOrderById(int id) {
        placedOrderDAO.deletePlacedOrderById(id);
    }

    @Override
    public void insertPlacedOrder(PlacedOrder placedOrder) {
        placedOrderDAO.insertPlacedOrder(placedOrder);
    }

    @Override
    public void updatePlacedOrder(PlacedOrder placedOrder) {
        placedOrderDAO.updatePlacedOrder(placedOrder);
    }

    @Override
    public List<PlacedOrder> getALlPlacedOrders() {
        return placedOrderDAO.getALlPlacedOrders();
    }

    @Override
    public List<PlacedOrder> getALlPlacedOrdersWithTakenFromWaiterConditionNotDelivered(boolean isTaken) {
        return placedOrderDAO.getALlPlacedOrdersWithTakenFromWaiterConditionNotDelivered(isTaken);
    }

    @Override
    public List<PlacedOrder> getALlDeliveredPlacedOrders() {
        return placedOrderDAO.getALlDeliveredPlacedOrders();
    }

    @Override
    public void setPlacedOrderDelivered(int id) {
        PlacedOrder placedOrder = getPlacedOrderById(id);
        placedOrder.setDelivered(true);
        updatePlacedOrder(placedOrder);
    }
}
