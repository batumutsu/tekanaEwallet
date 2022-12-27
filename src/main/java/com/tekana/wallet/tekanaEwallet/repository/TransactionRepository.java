package com.tekana.wallet.tekanaEwallet.repository;

import com.tekana.wallet.tekanaEwallet.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    // optional custom methods
}

