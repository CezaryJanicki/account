package com.kodilla.accounts.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Table
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nrb")
    private String nrb;

    @Column(name = "currency")
    private String currency;

    @Column(name = "availableFounds")
    private BigDecimal availableFounds;

    @Column(name = "customerId")
    private Long customerId;

    public Account(Long id, String nrb, String currency, BigDecimal availableFounds) {
        this.id = id;
        this.nrb = nrb;
        this.currency = currency;
        this.availableFounds = availableFounds;
    }
}
