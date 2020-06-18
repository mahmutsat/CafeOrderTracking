package com.mycafe.service;

import com.mycafe.dao.FoodCategoryDAO;
import com.mycafe.model.FoodCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodCategoryServiceImpl implements FoodCategoryService{
    @Autowired
    private FoodCategoryDAO foodCategoryDAO;

    @Override
    public void addFoodCategory(FoodCategory foodCategory) { foodCategoryDAO.addFoodCategory(foodCategory); }

    @Override
    public List<FoodCategory> getAllCategories() {
        return foodCategoryDAO.getAllCategories();
    }

    @Override
    public List<String> getAllCategoryNames() { return foodCategoryDAO.getAllCategoryNames(); }
}
