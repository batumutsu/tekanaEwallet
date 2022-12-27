package com.tekana.wallet.tekanaEwallet.controller;

import com.tekana.wallet.tekanaEwallet.model.Transaction;
import com.tekana.wallet.tekanaEwallet.model.Wallet;
import com.tekana.wallet.tekanaEwallet.service.TransactionService;
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
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @Operation(summary = "Get a transaction details", description = "Get details for a transaction", tags = "Get")
    @ApiResponses(value =  {
            @ApiResponse(responseCode = "200", description = "Transaction details found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Wallet.class))}),
            @ApiResponse(responseCode = "404", description = "Transaction details not found")
    })
    @GetMapping("{transactionId}")
    public Transaction getCustomerWalletDetails(@PathVariable Long transactionId) {
        return transactionService.getTransactionDetails(transactionId);
    }

    @Operation(summary = "Get a customer transactions details", description = "Get details for a customer transactions", tags = "Get")
    @ApiResponses(value =  {
            @ApiResponse(responseCode = "200", description = "Customer transaction details found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Transaction.class))}),
            @ApiResponse(responseCode = "404", description = "Customer transaction details not found")
    })
    @GetMapping("{customerId}")
    public List<Transaction> getCustomerTransactionsDetails(@PathVariable Long customerId) {
        return transactionService.getCustomerTransactionsDetails(customerId);
    }

    @Operation(summary = "Make a transaction", description = "This endpoint will help us, to make a new transaction", tags = "Post")
    @ApiResponses(value =  {
            @ApiResponse(responseCode = "200", description = "Make transaction",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Transaction.class))}),
            @ApiResponse(responseCode = "404", description = "Transaction was not succefull")
    })
    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        Transaction createdTransaction = transactionService.createTransaction(transaction);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTransaction);
    }

    @Operation(summary = "Update a transaction details", description = "This endpoint will help us, to update a transaction details", tags = "Put")
    @ApiResponses(value =  {
            @ApiResponse(responseCode = "200", description = "Transaction updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Transaction.class))}),
            @ApiResponse(responseCode = "404", description = "Transaction was not updated")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable Long id, @RequestBody Transaction transaction) {
        Transaction updatedTransaction = transactionService.updateTransaction(transaction);
        return ResponseEntity.ok(updatedTransaction);
    }
}

