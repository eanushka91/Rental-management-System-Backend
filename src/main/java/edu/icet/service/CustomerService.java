package edu.icet.service;

import edu.icet.dto.Customer;
import edu.icet.dto.Item;

import java.util.List;

public interface CustomerService {
    List<Customer> getAll();
    void addCustomer(Customer customer);
    void deleteCustomerById(Integer id);
    Customer searchCustomerById(Integer id);
    void updateCustomerById(Customer customer);
    Customer login(String email, String password);
    Customer register(Customer customer);
}
