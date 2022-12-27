package com.tekana.wallet.tekanaEwallet.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;
    @ManyToOne
    private Wallet source;
    @ManyToOne
    private Wallet destination;

    public Transaction() {
    }

    public Transaction(Long id, BigDecimal amount, Wallet source, Wallet destination) {
        this.id = id;
        this.amount = amount;
        this.source = source;
        this.destination = destination;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Wallet getSource() {
        return source;
    }

    public void setSource(Wallet source) {
        this.source = source;
    }

    public Wallet getDestination() {
        return destination;
    }

    public void setDestination(Wallet destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", source=" + source +
                ", destination=" + destination +
                '}';
    }
}

