package com.mycafe.controller;

import com.mycafe.model.Foods;
import com.mycafe.model.PlacedOrder;
import com.mycafe.service.PlacedOrderService;
import com.mycafe.utility.ModelAttributes;
import com.mycafe.utility.URLs;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Api(value = "Garsonlar View API'si")
public class WaiterViewController {
    @Autowired
    private PlacedOrderService placedOrderService;

    @GetMapping(value = URLs.WAITER)
    public String takeOrderForm(@ModelAttribute("order") PlacedOrder order, Model model){
        model.addAttribute("placedOrders", placedOrderService.getALlPlacedOrdersWithTakenFromWaiterConditionNotDelivered(true));
        model.addAttribute("deliveredOrders", placedOrderService.getALlDeliveredPlacedOrders());
        return URLs.WAITER_MENU;
    }

    @PostMapping(value = URLs.WAITER_TAKE_ORDER_BY_ID)
    @ApiOperation(value = "Takes the orders")
    public String takeOrder(@PathVariable("id") int id, @ModelAttribute("order") PlacedOrder order, Model model){
        PlacedOrder placedOrder = placedOrderService.getPlacedOrderById(id);
        placedOrder.setWaiterTakeTheOrder(true);
        placedOrder.setWaiterNameTookTheOrder(order.getWaiterNameTookTheOrder());
        placedOrderService.updatePlacedOrder(placedOrder);

        model.addAttribute("placedOrders", placedOrderService.getALlPlacedOrdersWithTakenFromWaiterConditionNotDelivered(false));
        model.addAttribute("waiters", ModelAttributes.prepareWaiters());
        return URLs.KITCHEN_MENU;
    }

    @GetMapping(value = URLs.DELETE_PLACED_ORDER_BY_ID)
    @ApiOperation(value = "Sets the foods are delivered")
    public String setOrderDelivered(@PathVariable("id") int id, @ModelAttribute("foodToBeAdded") Foods foodToBeAdded, Model model){
        placedOrderService.setPlacedOrderDelivered(id);
        model.addAttribute("placedOrders", placedOrderService.getALlPlacedOrdersWithTakenFromWaiterConditionNotDelivered(true));
        model.addAttribute("deliveredOrders", placedOrderService.getALlDeliveredPlacedOrders());
        return "redirect:" + URLs.WAITER;
    }
}
