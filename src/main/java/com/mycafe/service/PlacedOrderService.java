package com.mycafe.service;

import com.mycafe.model.PlacedOrder;

import java.util.List;

public interface PlacedOrderService {

    public PlacedOrder getPlacedOrderById(int id);

    public void deletePlacedOrderById(int id);

    public void insertPlacedOrder(PlacedOrder placedOrder);

    public void updatePlacedOrder(PlacedOrder placedOrder);

    public List<PlacedOrder> getALlPlacedOrders();

    public List<PlacedOrder> getALlPlacedOrdersWithTakenFromWaiterConditionNotDelivered(boolean isTaken);

    public List<PlacedOrder> getALlDeliveredPlacedOrders();

    public void setPlacedOrderDelivered(int id);
}
