package com.kodilla.accounts.repository;

import com.kodilla.accounts.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findById(Long id);

    Account getAccountById(Long account);

    @Override
    List<Account> findAll();

    @Override
    Account save(Account account);

    void deleteById(long id);

    @Override
    long count();

    //List<Account> findByCustomerId(long id);
}
