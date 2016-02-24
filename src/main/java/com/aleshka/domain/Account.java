package com.aleshka.domain;

import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Calendar;


@Entity(name = "Account")
@EntityListeners(AuditingEntityListener.class)
public class Account extends AbstractAuditable<User, Long>
{
    private String customer;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar expiryDate;


    public Account () {}

    public Account(String customer, Calendar expiryDate)
    {
        this.customer = customer;
        this.expiryDate = expiryDate;
    }

    public String getCustomer()
    {
        return customer;
    }

    public void setCustomer(String customer)
    {
        this.customer = customer;
    }

    public Calendar getExpiryDate()
    {
        return expiryDate;
    }

    public void setExpiryDate(Calendar expiryDate)
    {
        this.expiryDate = expiryDate;
    }
}