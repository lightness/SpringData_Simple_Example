package com.aleshka.repository;

import com.aleshka.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional(readOnly = true)
public interface AccountRepository extends JpaRepository<Account, Long>
{
    List<Account> findByCustomer(String customer);

    List<Account> findAllByOrderByCustomerAsc();
}