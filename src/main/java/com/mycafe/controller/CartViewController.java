package com.mycafe.controller;

import com.mycafe.model.Customer;
import com.mycafe.model.FoodOrder;
import com.mycafe.model.Foods;
import com.mycafe.model.PlacedOrder;
import com.mycafe.service.CustomerService;
import com.mycafe.service.FoodService;
import com.mycafe.service.FoodOrderService;
import com.mycafe.service.PlacedOrderService;
import com.mycafe.utility.URLs;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@Api(value = "Sepet View API'si")
public class CartViewController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private FoodOrderService foodOrderService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PlacedOrderService placedOrderService;

    @GetMapping(value = URLs.ADD_FOOD_BY_ID)
    @ApiOperation(value = "Allows to delete a food.")
    public String processDeleteFood(@PathVariable("id") int id, Model model){
        Foods food = foodService.getFoodById(id);
        Customer customer = customerService.getActiveCustomer();
        foodOrderService.insertOrder(food,customer);

        model.addAttribute("foods",foodService.getFoodsWithCategoryType());
        model.addAttribute("customerName",customerService.getActiveCustomer().getCustomerName());
        return URLs.HOME_MENU;
    }

    @GetMapping(value = URLs.CART)
    @ApiOperation(value = "Provides access to Cart View.")
    public String cart(Model model){
        final Integer[] totalAmount = {0};

        foodOrderService.getOrdersWithPlacedType(false).forEach((customer, foodOrders) -> {
            foodOrders.forEach(order -> {
                order.getFoods().forEach(foods -> {
                    System.out.println(foods.getPrice());
                    totalAmount[0] +=foods.getPrice();
                });
            });
        });

        model.addAttribute("allCustomerOrders", foodOrderService.getOrdersWithPlacedType(false));
        model.addAttribute("ordersTotals",totalAmount[0]);
        return URLs.CART_MENU;
    }

    @GetMapping(value = URLs.PLACE_ORDER)
    @ApiOperation(value = "Allows to give an order.")
    public String placeOrder(
            @RequestParam(value = "orderDescription",required = false, defaultValue = "") String orderDescription,
            @RequestParam(value = "tableNo") String tableNo, Model model){
        customerService.setOrdersAsPlaced();

        Map<Customer, List<FoodOrder>> orderMap = foodOrderService.getOrdersWithPlacedType(true);

        orderMap.forEach((customer, foodOrders) -> {
            PlacedOrder placedOrder = new PlacedOrder();
            placedOrder.setCustomer(customer);
            placedOrder.setFoodOrders(foodOrders);
            placedOrder.setTableNo(tableNo);
            placedOrder.setOrderDescription(orderDescription);
            placedOrderService.insertPlacedOrder(placedOrder);
        });

        model.addAttribute("foods",foodService.getFoodsWithCategoryType());
        model.addAttribute("customerName",customerService.getActiveCustomer().getCustomerName());
        return URLs.HOME_MENU;
    }
}
