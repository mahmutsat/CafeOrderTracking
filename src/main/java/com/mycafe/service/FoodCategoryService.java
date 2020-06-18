package com.mycafe.service;

import com.mycafe.model.FoodCategory;

import java.util.List;

public interface FoodCategoryService {

    public void addFoodCategory(FoodCategory foodCategory);

    public List<FoodCategory> getAllCategories();

    public List<String> getAllCategoryNames();
}
