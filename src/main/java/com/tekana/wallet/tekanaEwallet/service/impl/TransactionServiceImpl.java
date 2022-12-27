package com.tekana.wallet.tekanaEwallet.service.impl;

import com.tekana.wallet.tekanaEwallet.model.Transaction;
import com.tekana.wallet.tekanaEwallet.repository.TransactionRepository;
import com.tekana.wallet.tekanaEwallet.service.TransactionService;
import com.tekana.wallet.tekanaEwallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private WalletService walletService;

    public Transaction createTransaction(Transaction transaction) {
        // validate input data
        walletService.subtractFunds(transaction.getSource(), transaction.getAmount());
        walletService.addFunds(transaction.getDestination(), transaction.getAmount());
        return transactionRepository.save(transaction);
    }

    public Transaction updateTransaction(Transaction transaction) {
        // validate input data
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction getTransactionDetails(Long transactionId) {
        Optional<Transaction> transaction = transactionRepository.findById(transactionId);
        return transaction.isPresent() ? transaction.get() : null;
    }
}

