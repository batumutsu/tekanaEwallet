package com.tekana.wallet.tekanaEwallet.service;

import com.tekana.wallet.tekanaEwallet.model.Customer;
import java.util.List;

public interface CustomerService {
    public Customer createCustomer(Customer customer);
    public Customer updateCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Customer getCustomerDetails(Long customerId);
}
