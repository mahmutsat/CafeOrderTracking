package com.mycafe.dao;

import com.mycafe.model.Foods;
import com.mycafe.service.FoodCategoryService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FoodRepositoryDaoImpl implements FoodRepositoryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private FoodCategoryService foodCategoryService;

    @Override
    public List<Foods> getAllFoods() {
        Session session = sessionFactory.getCurrentSession();
        String query = "SELECT allFoods FROM foods allFoods";
        TypedQuery<Foods> mainCoursesTypedQuery = session.createQuery(query, Foods.class);
        return mainCoursesTypedQuery.getResultList();
    }

    public List<Foods> getAllStarters() {
        if (sessionFactory != null){
            Session session = sessionFactory.getCurrentSession();
            String query = "SELECT starter FROM foods starter where starter.type = 'Baslangiclar'";
            TypedQuery<Foods> startersTypedQuery = session.createQuery(query, Foods.class);
            return startersTypedQuery.getResultList();
        }
        else{
            System.err.println("session factory null");
            return null;
        }
    }

    public List<Foods> getAllMainCourses() {
        Session session = sessionFactory.getCurrentSession();
        String query = "SELECT starter FROM foods starter where starter.type = 'Ana Yemekler'";
        TypedQuery<Foods> mainCoursesTypedQuery = session.createQuery(query, Foods.class);
        return mainCoursesTypedQuery.getResultList();
    }

    public List<Foods> getAllDrinks() {
        Session session = sessionFactory.getCurrentSession();
        String query = "SELECT starter FROM foods starter where starter.type = 'Icecekler'";
        TypedQuery<Foods> drinksTypedQuery = session.createQuery(query, Foods.class);
        return drinksTypedQuery.getResultList();
    }

    @Override
    public Map<String, List<Foods>> getFoodsWithCategoryType() {
        Session session = sessionFactory.getCurrentSession();
        String query = "SELECT categorizedFood FROM foods categorizedFood where categorizedFood.type = :categoryName";
        Map<String, List<Foods>> categorizedFoodMap = new HashMap<>();

        foodCategoryService.getAllCategories().forEach(foodCategory -> {
            TypedQuery<Foods> foodsTypedQuery = session.createQuery(query, Foods.class).setParameter("categoryName",foodCategory.getCategoryName());
            categorizedFoodMap.put(foodCategory.getCategoryName(),foodsTypedQuery.getResultList());
        });

        return categorizedFoodMap;
    }

    @Override
    public Foods getFoodById(int id) {
        Session session = sessionFactory.getCurrentSession();
        String query = "SELECT food FROM foods food where food.id = :foodid" ;
        TypedQuery<Foods> food =  session.createQuery(query, Foods.class).setParameter("foodid",id);
        System.out.println(food);
        return food.getSingleResult();
    }

    @Override
    @Transactional
    public void addFood(Foods food) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(food);
    }

    @Override
    @Transactional
    public void deleteFood(int id) {
        Session session = sessionFactory.getCurrentSession();
        Foods food = (Foods) session.get(Foods.class, id);

        if (food != null)
            session.delete(food);
    }
}
