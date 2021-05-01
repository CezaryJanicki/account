package com.kodilla.accounts.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    private Long id;
    private String nrb;
    private String currency;
    private BigDecimal availableFounds;
}
