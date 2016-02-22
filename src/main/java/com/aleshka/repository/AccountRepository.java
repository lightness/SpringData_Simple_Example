package com.aleshka.repository;

import com.aleshka.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional(readOnly = true)
public interface AccountRepository extends JpaRepository<Account, Long>, AccountRepositoryCustom, JpaSpecificationExecutor
{
    // ### Query support

    //List<Account> findByCustomer(String customer);
    @Query("select a from Account a where a.customer = :customer")
    List<Account> findByCustomer(@Param("customer") String customer);

    @Query("select a from Account a where mod(a.id, 2) = 1")
    List<Account> findAllWithOddId();

    @Modifying
    @Transactional
    @Query("update Account a set a.customer = ?2 where a.id = ?1 ")
    void updateCustomerById(Long id, String customer);

    // ### Spring data
    List<Account> findAllByOrderByCustomerAsc();

    //List<Account> findByCustomerContaining(String term);
}