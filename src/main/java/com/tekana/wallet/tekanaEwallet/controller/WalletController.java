package com.tekana.wallet.tekanaEwallet.controller;

import com.tekana.wallet.tekanaEwallet.model.Wallet;
import com.tekana.wallet.tekanaEwallet.service.WalletService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wallets")
public class WalletController {
    @Autowired
    private WalletService walletService;

    @Operation(summary = "Get a wallet", description = "Get details for wallet", tags = "Get")
    @ApiResponses(value =  {
            @ApiResponse(responseCode = "200", description = "Wallet details found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Wallet.class))}),
            @ApiResponse(responseCode = "404", description = "Wallet details not found")
    })
    @GetMapping("{walletId}")
    public Wallet getWalletDetails(@PathVariable Long walletId) {
        return walletService.getWalletDetails(walletId);
    }

    @Operation(summary = "Get a customer wallets", description = "Get details for customer wallets", tags = "Get")
    @ApiResponses(value =  {
            @ApiResponse(responseCode = "200", description = "Customer wallets details found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Wallet.class))}),
            @ApiResponse(responseCode = "404", description = "Customer wallets details not found")
    })
    @GetMapping("{customerId}")
    public List<Wallet> getCustomerWalletDetails(@PathVariable Long customerId) {
        return walletService.getCustomerWalletDetails(customerId);
    }
    @PostMapping
    public ResponseEntity<Wallet> createWallet(@RequestBody Wallet wallet) {
        Wallet createdWallet = walletService.createWallet(wallet);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdWallet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Wallet> updateWallet(@PathVariable Long id, @RequestBody Wallet wallet) {
        Wallet updatedWallet = walletService.updateWallet(wallet);
        return ResponseEntity.ok(updatedWallet);
    }
}

