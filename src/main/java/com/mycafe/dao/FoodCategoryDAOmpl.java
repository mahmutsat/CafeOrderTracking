package com.mycafe.dao;

import com.mycafe.model.FoodCategory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

public class FoodCategoryDAOmpl implements FoodCategoryDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void addFoodCategory(FoodCategory foodCategory) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(foodCategory);
    }

    @Override
    public List<FoodCategory> getAllCategories() {
        Session session = sessionFactory.getCurrentSession();
        String query = "SELECT category FROM FoodCategory category" ;
        TypedQuery<FoodCategory> categories =  session.createQuery(query, FoodCategory.class);
        return categories.getResultList();
    }

    @Override
    public List<String> getAllCategoryNames() {
        Session session = sessionFactory.getCurrentSession();
        String query = "SELECT category.categoryName FROM FoodCategory category" ;
        TypedQuery<String> categories =  session.createQuery(query, java.lang.String.class);
        return categories.getResultList();
    }
}
