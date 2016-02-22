package com.aleshka.repository;

import com.aleshka.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class AccountRepositoryImpl implements AccountRepositoryCustom
{
    private static final String QUERY = "select customer from Account a where lower(a.customer) like lower(concat('%', :searchTerm, '%'))";

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    @Transactional(readOnly = true)
    public List<Account> findBySearchTerm(String searchTerm)
    {
        Map<String, String> queryParams = new HashMap<String, String>();
        queryParams.put("searchTerm", searchTerm);

        return jdbcTemplate.query(QUERY,
                queryParams,
                new BeanPropertyRowMapper<Account>(Account.class));
    }
}
