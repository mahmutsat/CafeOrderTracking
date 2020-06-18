package com.mycafe.service;

import com.mycafe.dao.FoodRepositoryDAO;
import com.mycafe.model.Foods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FoodServiceImpl implements FoodService{

    @Autowired
//    @Qualifier("foodRepositoryDaoImpl")
    private FoodRepositoryDAO foodRepositoryDao;

    @Override
    public List<Foods> getAllFoods() { return foodRepositoryDao.getAllFoods(); }

    @Override
    public List<Foods> getAllStarters() {
        return foodRepositoryDao.getAllStarters();
    }

    @Override
    public List<Foods> getAllMainCourses() {
        return foodRepositoryDao.getAllMainCourses();
    }

    @Override
    public List<Foods> getAllDrinks() {
        return foodRepositoryDao.getAllDrinks();
    }

    @Override
    public Map<String, List<Foods>> getFoodsWithCategoryType() { return foodRepositoryDao.getFoodsWithCategoryType(); }

    @Override
    public Foods getFoodById(int id) { return foodRepositoryDao.getFoodById(id); }

    @Override
    public void addFood(Foods food) {
        foodRepositoryDao.addFood(food);
    }

    @Override
    public void deleteFood(int id) {
        foodRepositoryDao.deleteFood(id);
    }
}
