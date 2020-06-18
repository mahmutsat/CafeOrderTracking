package com.mycafe.dao;

import com.mycafe.model.Foods;
import com.mycafe.model.PlacedOrder;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

public class PlacedOrderDAOImpl implements PlacedOrderDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public PlacedOrder getPlacedOrderById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(PlacedOrder.class).add(Restrictions.eq("id", id));
        return (PlacedOrder) criteria.list().get(0);
    }

    @Override
    @Transactional
    public void deletePlacedOrderById(int id) {
        Session session = sessionFactory.getCurrentSession();
        String query = "SELECT placedOrder FROM PlacedOrder placedOrder where placedOrder.id = :placedOrderid" ;
        TypedQuery<PlacedOrder> placedOrder =  session.createQuery(query, PlacedOrder.class).setParameter("placedOrderid",id);
        session.delete(placedOrder.getSingleResult());
    }

    @Override
    @Transactional
    public void insertPlacedOrder(PlacedOrder placedOrder) {
        Session session = sessionFactory.getCurrentSession();
        placedOrder.getCustomer().getOrders().clear();
        session.update(placedOrder.getCustomer());
        session.save(placedOrder);
    }

    @Override
    @Transactional
    public void updatePlacedOrder(PlacedOrder placedOrder) {
        Session session = sessionFactory.getCurrentSession();
        session.update(placedOrder);
    }

    @Override
    public List<PlacedOrder> getALlPlacedOrders() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(PlacedOrder.class);
        return criteria.list();
    }

    @Override
    public List<PlacedOrder> getALlPlacedOrdersWithTakenFromWaiterConditionNotDelivered(boolean isTaken) {
        Session session = sessionFactory.getCurrentSession();
        Criterion isTakenCriterion = Restrictions.eq("isWaiterTakeTheOrder", isTaken);
        Criterion notDeliveredCriterion = Restrictions.eq("isDelivered",false);

        Criteria criteria = session.createCriteria(PlacedOrder.class).add(Restrictions.and(isTakenCriterion,notDeliveredCriterion));
        return criteria.list();
    }

    @Override
    public List<PlacedOrder> getALlDeliveredPlacedOrders() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(PlacedOrder.class).add(Restrictions.eq("isDelivered",true));
        return criteria.list();
    }
}
