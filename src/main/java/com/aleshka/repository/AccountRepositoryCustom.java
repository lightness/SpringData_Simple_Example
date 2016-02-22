package com.aleshka.repository;


import com.aleshka.domain.Account;

import java.util.List;


public interface AccountRepositoryCustom
{
    List<Account> findBySearchTerm(String searchTerm);
}
