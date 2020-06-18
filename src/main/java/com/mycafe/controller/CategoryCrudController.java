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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Api(value = "Kategori CRUD işlemler API'si")
public class CategoryCrudController {
    @Autowired
    private FoodService foodService;

    @Autowired
    private FoodCategoryService foodCategoryService;

    @PostMapping(value = URLs.ADD_CATEGORY)
    @ApiOperation(value = "Allows to add a new food category.")
    public String processAddNewFood(@ModelAttribute("foodToBeAdded") Foods foodToBeAdded, @ModelAttribute("categoryToBeAdded") FoodCategory categoryToBeAdded, Model model){
        foodCategoryService.addFoodCategory(categoryToBeAdded);
        model.addAttribute("foods", foodService.getAllFoods());
        model.addAttribute("foodCategories", foodCategoryService.getAllCategoryNames());
        return "redirect:" + URLs.ADMIN;
    }
}
