package com.aleshka.service;

import com.aleshka.domain.Account;

import java.util.List;


public interface AccountService
{
    Account save(Account account);

    List<Account> findByCustomer(String customer);
}
