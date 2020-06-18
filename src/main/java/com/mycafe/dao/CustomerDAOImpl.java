package com.mycafe.dao;

import com.mycafe.model.Customer;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CustomerDAOImpl implements CustomerDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void addCustomerWithName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = new Customer();
        customer.setCustomerName(name);
        customer.setActive(true);
        session.persist(customer);
    }

    @Override
    public void addCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(customer);
    }

    @Override
    public Customer getActiveCustomer() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Customer.class);
        criteria.add(Restrictions.eq("isActive",true));
        return (Customer) criteria.list().get(0);
    }

    @Override
    public List<Customer> getAllCustomers() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Customer.class);
        return criteria.list();
    }

    @Override
    @Transactional
    public void setDeactiveCustomer() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Customer.class);
        criteria.add(Restrictions.eq("isActive",true));

        if (criteria.list().size() != 0){
            Customer customer = (Customer) criteria.list().get(0);
            customer.setActive(false);
            session.update(customer);
        }
    }

    @Override
    @Transactional
    public void removeAllCustomersExceptActiveCustomer() {
        Session session = sessionFactory.getCurrentSession();
        List<Customer> customers = session.createCriteria(Customer.class).list();
        customers.forEach(customer -> {
            if (!customer.isActive()){
                session.delete(customer);
            } else {
                customer.setOrders(null);
                session.update(customer);
            }
        });
    }

    @Override
    @Transactional
    public void setOrdersAsPlaced() {
        Session session = sessionFactory.getCurrentSession();
        List<Customer> customers = session.createCriteria(Customer.class).list();
        customers.forEach(customer -> {
            customer.getOrders().forEach(foodOrder ->
            {
                foodOrder.setOrderPlaced(true);
                session.update(customer);
                session.update(foodOrder);
            });
        });
    }
}
