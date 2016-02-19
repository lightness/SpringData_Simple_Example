package com.aleshka.domain;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Account
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customer;

    @Temporal(TemporalType.DATE)
    private Date expiryDate;


    public Account () {}

    public Account(String customer, Date expiryDate)
    {
        this.customer = customer;
        this.expiryDate = expiryDate;
    }

    public Long getId()
    {
        return id;
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