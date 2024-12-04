package edu.icet.service.impl;

import edu.icet.config.SecurityConfig;
import edu.icet.dto.Customer;
import edu.icet.entity.CustomerEntity;
import edu.icet.repository.CustomerRepository;
import edu.icet.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repository;
    private final ModelMapper mapper;
    @Override
    public List<Customer> getAll() {
        List<Customer> customerArrayList = new ArrayList<>();
        repository.findAll().forEach(entity ->{
            customerArrayList.add(mapper.map(entity, Customer.class));
        });
        return customerArrayList;
    }

    @Override
    public void addCustomer(Customer customer) {
        repository.save(mapper.map(customer, CustomerEntity.class));
    }

    @Override
    public void deleteCustomerById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Customer searchCustomerById(Integer id) {
        return mapper.map(repository.findById(id), Customer.class);
    }

    @Override
    public void updateCustomerById(Customer customer) {
        repository.save(mapper.map(customer, CustomerEntity.class));
    }

    @Override
    public Customer login(String email, String password) {
        CustomerEntity customerEntity = repository.findByEmail(email);

        if(customerEntity == null) {
            throw new RuntimeException("Could not found");
        }

        if(!SecurityConfig.verifyPassword(password, customerEntity.getPassword())){
            throw new RuntimeException("Password not matched");
        }

        return mapper.map(customerEntity, Customer.class);

    }
    @Override
    public Customer register(Customer customer) {
        customer.setPassword(SecurityConfig.hashPassword(customer.getPassword()));
        CustomerEntity userEntity = repository.save(mapper.map(customer, CustomerEntity.class));
        return mapper.map(userEntity, Customer.class);
    }

}
