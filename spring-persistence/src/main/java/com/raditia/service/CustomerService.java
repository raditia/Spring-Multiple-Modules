package com.raditia.service;

import com.raditia.entity.Address;
import com.raditia.entity.Customer;
import org.springframework.data.domain.Page;

public interface CustomerService {

    Customer register(String name, Address address);
    Customer getCustomer(String id);
    Page<Customer> getAllCustomers(int pageNumber);
    Customer deleteCustomer(String id);
    Customer editCustomer(Customer customer);
}
