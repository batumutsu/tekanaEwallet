package com.tekana.wallet.tekanaEwallet.repository;

import com.tekana.wallet.tekanaEwallet.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    List<Transaction> findTransactionsBySource_Customer_IdOrDestination_CustomerId(Long customerSrcId, Long customerDestId);
    // optional custom methods
}

