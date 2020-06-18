package com.mycafe.controller;

import com.mycafe.service.CustomerService;
import com.mycafe.service.FoodServiceImpl;
import com.mycafe.utility.URLs;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Api(value = "Ana Menü API'si")
public class HomeViewController {

    @Autowired
    private FoodServiceImpl foodService;

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = URLs.HOME)
    @ApiOperation(value = "Lists all foods on the main view")
    public ModelAndView listAllProducts(@RequestParam(value = "name",required = false, defaultValue = "") String customerName, Model model){
        ModelAndView modelAndView = new ModelAndView(URLs.HOME_MENU);
        model.addAttribute("foods",foodService.getFoodsWithCategoryType());

        if (!customerName.isEmpty()){
            customerService.addCustomerWithName(customerName);
            model.addAttribute("customerName",customerName.toUpperCase());
        } else{
            model.addAttribute("customerName",customerService.getActiveCustomer().getCustomerName());
        }

        return modelAndView;
    }

    @GetMapping(value = URLs.DEFAULT_URL)
    @ApiOperation(value = "Redirects to login page")
    public ModelAndView login(){
        return new ModelAndView(URLs.LOGIN_MENU);
    }

    @GetMapping(value = URLs.LOGIN)
    @ApiOperation(value = "Redirects to login page when user changes")
    public ModelAndView newCustomer(){
        customerService.setDeactiveCustomer();
        return new ModelAndView(URLs.LOGIN_MENU);
    }
}
