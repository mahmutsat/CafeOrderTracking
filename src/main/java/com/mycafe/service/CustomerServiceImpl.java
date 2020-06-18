package com.mycafe.service;

import com.mycafe.dao.CustomerDAO;
import com.mycafe.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public void addCustomerWithName(String name) {
        customerDAO.addCustomerWithName(name);
    }

    @Override
    public void addCustomer(Customer customer) {
        customerDAO.addCustomer(customer);
    }

    @Override
    public Customer getActiveCustomer() {
       return customerDAO.getActiveCustomer();
    }

    @Override
    public List<Customer> getAllCustomers() { return customerDAO.getAllCustomers(); }

    @Override
    public void setDeactiveCustomer() { customerDAO.setDeactiveCustomer(); }

    @Override
    public void removeAllCustomersExceptActiveCustomer() { customerDAO.removeAllCustomersExceptActiveCustomer(); }

    @Override
    public void setOrdersAsPlaced() { customerDAO.setOrdersAsPlaced(); }
}
