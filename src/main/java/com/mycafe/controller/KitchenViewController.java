package com.mycafe.controller;

import com.mycafe.model.PlacedOrder;
import com.mycafe.service.PlacedOrderService;
import com.mycafe.utility.ModelAttributes;
import com.mycafe.utility.URLs;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Api(value = "Ana View API'si")
public class KitchenViewController {
    @Autowired
    private PlacedOrderService placedOrderService;

    @GetMapping(value = URLs.KITCHEN)
    @ApiOperation(value = "Redirects to kitchen page")
    public String kitchen(Model model, @ModelAttribute("order") PlacedOrder order){
        model.addAttribute("placedOrders", placedOrderService.getALlPlacedOrdersWithTakenFromWaiterConditionNotDelivered(false));
        model.addAttribute("waiters", ModelAttributes.prepareWaiters());
        return URLs.KITCHEN_MENU;
    }
}
