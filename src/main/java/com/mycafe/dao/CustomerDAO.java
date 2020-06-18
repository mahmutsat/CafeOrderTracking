package com.mycafe.dao;

import com.mycafe.model.Customer;

import java.util.List;

public interface CustomerDAO {
    public void addCustomerWithName(String name);

    public void addCustomer(Customer customer);

    public Customer getActiveCustomer();

    public List<Customer> getAllCustomers();

    public void setDeactiveCustomer();

    public void removeAllCustomersExceptActiveCustomer();

    public void setOrdersAsPlaced();
}
