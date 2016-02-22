package com.aleshka.repository.specification;

import com.aleshka.domain.Account;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


public class AccountSpecs
{
    public static Specification<Account> isCustomerContains(final String term)
    {
        return new Specification<Account>()
        {
            public Predicate toPredicate(
                    Root<Account> root,
                    CriteriaQuery<?> query,
                    CriteriaBuilder builder)
            {
                return builder.like(builder.lower(root.get(root.getModel().getDeclaredSingularAttribute("customer", String.class))), "%" + term.toLowerCase() + "%");
            }
        };
    }
}
