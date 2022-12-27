package com.tekana.wallet.tekanaEwallet.service.impl;

import com.tekana.wallet.tekanaEwallet.model.Customer;
import com.tekana.wallet.tekanaEwallet.repository.CustomerRepository;
import com.tekana.wallet.tekanaEwallet.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {
        // validate input data
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer) {
        // validate input data
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    public Customer getCustomerDetails(Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        return customer.isPresent() ? customer.get() : null;
    }
}

