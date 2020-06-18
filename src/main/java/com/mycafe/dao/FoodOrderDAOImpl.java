package com.mycafe.dao;

import com.mycafe.model.Customer;
import com.mycafe.model.Foods;
import com.mycafe.model.FoodOrder;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodOrderDAOImpl implements FoodOrderDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void insertOrder(Foods food , Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        FoodOrder order = new FoodOrder();
        order.getFoods().add(food);
        order.setOrderPlaced(false);
        order.setCustomer(customer);
        customer.getOrders().add(order);

        session.save(order);
        session.update(customer);
    }

    @Override
    public List<FoodOrder> getOrderList() {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<FoodOrder> query = session.createQuery("from FoodOrder", FoodOrder.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void removeAllOrders() {
        Session session = sessionFactory.getCurrentSession();
        List<FoodOrder> orders = session.createCriteria(FoodOrder.class).list();
        orders.forEach(foodOrder -> {
            session.delete(foodOrder);
        });
    }

    @Override
    public Map<Customer, List<FoodOrder>> getOrdersWithPlacedType(boolean isPlaced) {
        Session session = sessionFactory.getCurrentSession();

        Map<Customer, List<FoodOrder>> orderMap = new HashMap<>();

        getCustomersHaveAnOrder().forEach(customer -> {
            if (customer.getOrders().size() != 0){
                List<FoodOrder> foodOrders = new ArrayList<>();
                customer.getOrders().forEach(foodOrder -> {
                    if (foodOrder.isOrderPlaced() == isPlaced)
                    {
                        foodOrders.add(foodOrder);
                    }
                });
                orderMap.put(customer, foodOrders);
            }
        });

        return orderMap;
    }

    @Override
    public List<Customer> getCustomersHaveAnOrder() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Customer.class);
        return  criteria.list();
    }
}
