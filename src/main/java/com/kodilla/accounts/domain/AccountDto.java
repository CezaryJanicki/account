package com.kodilla.accounts.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    private Long id;
    private String nrb;
    private String currency;
    private BigDecimal availableFounds;
}
