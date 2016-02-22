package com.aleshka.domain;

import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;


@Entity
@EntityListeners(AuditingEntityListener.class)
public class Account extends AbstractAuditable<User, Long>
{
    private String customer;

    @Temporal(TemporalType.DATE)
    private Date expiryDate;


    public Account () {}

    public Account(String customer, Date expiryDate)
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

    public Date getExpiryDate()
    {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate)
    {
        this.expiryDate = expiryDate;
    }

}