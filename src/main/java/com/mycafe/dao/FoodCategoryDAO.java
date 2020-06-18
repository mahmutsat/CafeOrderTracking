package com.mycafe.dao;

import com.mycafe.model.FoodCategory;

import java.util.List;

public interface FoodCategoryDAO {

    public void addFoodCategory(FoodCategory foodCategory);

    public List<FoodCategory> getAllCategories();

    public List<String> getAllCategoryNames();
}
