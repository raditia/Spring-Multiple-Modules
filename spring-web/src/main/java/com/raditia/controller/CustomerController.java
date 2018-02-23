package com.raditia.controller;

import com.raditia.entity.Customer;
import com.raditia.request.AddCustomerRequest;
import com.raditia.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, // Apa yang dikirim
            consumes = MediaType.APPLICATION_JSON_VALUE // Apa yang diterima
    )
    public Customer register(@Valid @RequestBody AddCustomerRequest request) {
        return customerService.register(request.getName(), request.getAddress());
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE // Apa yang dikirim
    )
    public Customer getCustomer(@PathVariable String id) {
        return customerService.getCustomer(id);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE // Apa yang dikirim
    )
    public Page<Customer> getAllCustomers(@RequestParam(name = "page", defaultValue = "1") int pageNumber) {
        return customerService.getAllCustomers(pageNumber);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE
//            produces = MediaType.APPLICATION_JSON_VALUE // Apa yang dikirim
    )
    public Customer deleteCustomers(@PathVariable String id) {
        return customerService.deleteCustomer(id);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE, // Apa yang dikirim
            consumes = MediaType.APPLICATION_JSON_VALUE // Apa yang diterima
    )
    public Customer editCustomer(@PathVariable String id, @Valid @RequestBody AddCustomerRequest request) {
        Customer customer = new Customer();

        customer.setId(id);
        customer.setName(request.getName());

        return customerService.editCustomer(customer);
    }
}
