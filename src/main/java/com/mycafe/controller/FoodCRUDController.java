package com.mycafe.controller;

import com.mycafe.model.FoodCategory;
import com.mycafe.model.Foods;
import com.mycafe.service.FoodCategoryService;
import com.mycafe.service.FoodService;
import com.mycafe.utility.URLs;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Api(value = "Ürünlerin CRUD işlemleri API'si")
public class FoodCRUDController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private FoodCategoryService foodCategoryService;

    @GetMapping(value = URLs.ADMIN)
    public String getAddNewFoodForm(@ModelAttribute("foodToBeAdded") Foods foodToBeAdded, @ModelAttribute("categoryToBeAdded") FoodCategory categoryToBeAdded, Model model){
        model.addAttribute("foods", foodService.getAllFoods());
        model.addAttribute("foodCategories", foodCategoryService.getAllCategoryNames());
        return URLs.ADMIN_MENU;
    }

    @PostMapping(value = "/adminAddFood")
    @ApiOperation(value = "Process to an a new food")
    public String processAddNewFood(@ModelAttribute("foodToBeAdded") Foods foodToBeAdded, @ModelAttribute("categoryToBeAdded") FoodCategory categoryToBeAdded, Model model){
        foodService.addFood(foodToBeAdded);
        model.addAttribute("foods", foodService.getAllFoods());
        model.addAttribute("foodCategories", foodCategoryService.getAllCategoryNames());
        return "redirect:" + URLs.ADMIN;
    }

    @GetMapping(value = URLs.FOOD_DELETE_BY_ID)
    @ApiOperation(value = "Process to delete a food by id")
    public String processDeleteFood(@PathVariable("id") int id, @ModelAttribute("foodToBeAdded") Foods foodToBeAdded, @ModelAttribute("categoryToBeAdded") FoodCategory categoryToBeAdded, Model model){
        foodService.deleteFood(id);
        model.addAttribute("foods", foodService.getAllFoods());
        model.addAttribute("foodCategories", foodCategoryService.getAllCategoryNames());
        return URLs.ADMIN_MENU;
    }
}
