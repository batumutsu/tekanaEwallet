package com.tekana.wallet.tekanaEwallet.service;

import com.tekana.wallet.tekanaEwallet.model.Wallet;
import java.math.BigDecimal;
import java.util.List;

public interface WalletService {
    public Wallet createWallet(Wallet wallet);
    public Wallet updateWallet(Wallet wallet);
    public void addFunds(Wallet wallet, BigDecimal amount);
    public void subtractFunds(Wallet wallet, BigDecimal amount);
    public Wallet getWalletDetails(Long walletId);
    List<Wallet> getCustomerWalletDetails(Long customerId);
}
