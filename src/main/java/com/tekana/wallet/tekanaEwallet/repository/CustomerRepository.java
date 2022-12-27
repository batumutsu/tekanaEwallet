package com.tekana.wallet.tekanaEwallet.repository;

import com.tekana.wallet.tekanaEwallet.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    // optional custom methods
}
