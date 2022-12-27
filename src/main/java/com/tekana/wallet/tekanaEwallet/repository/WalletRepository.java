package com.tekana.wallet.tekanaEwallet.repository;

import com.tekana.wallet.tekanaEwallet.model.Wallet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface WalletRepository extends CrudRepository<Wallet, Long> {
    List<Wallet> findByCustomerId(Long customerId);
    // optional custom methods
}

