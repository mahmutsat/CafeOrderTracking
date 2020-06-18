package com.mycafe.service;

import com.mycafe.model.Foods;

import java.util.List;
import java.util.Map;

public interface FoodService {
    public List<Foods> getAllFoods();

    public List<Foods> getAllStarters();

    public List<Foods> getAllMainCourses();

    public List<Foods> getAllDrinks();

    public Map<String, List<Foods>> getFoodsWithCategoryType();

    public Foods getFoodById(int id);

    public void addFood(Foods food);

    public void deleteFood(int id);
}
