package com.tekana.wallet.tekanaEwallet.service;

import com.tekana.wallet.tekanaEwallet.model.Transaction;
import java.util.List;

public interface TransactionService {
    public Transaction createTransaction(Transaction transaction);
    public Transaction updateTransaction(Transaction transaction);
    public Transaction getTransactionDetails(Long transactionId);
    public List<Transaction> getCustomerTransactionsDetails(Long customerId);
}
