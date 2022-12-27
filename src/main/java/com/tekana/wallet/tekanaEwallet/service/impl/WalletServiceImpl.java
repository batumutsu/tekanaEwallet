package com.tekana.wallet.tekanaEwallet.service.impl;

import com.tekana.wallet.tekanaEwallet.model.Wallet;
import com.tekana.wallet.tekanaEwallet.repository.WalletRepository;
import com.tekana.wallet.tekanaEwallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class WalletServiceImpl implements WalletService {
    @Autowired
    private WalletRepository walletRepository;

    public Wallet createWallet(Wallet wallet) {
        // validate input data
        return walletRepository.save(wallet);
    }

    public Wallet updateWallet(Wallet wallet) {
        // validate input data
        return walletRepository.save(wallet);
    }

    public void addFunds(Wallet wallet, BigDecimal amount) {
        wallet.setBalance(wallet.getBalance().add(amount));
        walletRepository.save(wallet);
    }

    public void subtractFunds(Wallet wallet, BigDecimal amount) {
        wallet.setBalance(wallet.getBalance().subtract(amount));
        walletRepository.save(wallet);
    }

    public Wallet getWalletDetails(Long walletId) {
        Optional<Wallet> client = walletRepository.findById(walletId);
        return client.isPresent() ? client.get() : null;
    }

    @Override
    public List<Wallet> getCustomerWalletDetails(Long customerId) {
        return walletRepository.findByCustomerId(customerId);
    }
}

