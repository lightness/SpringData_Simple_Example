package com.aleshka.domain;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;


@Entity
@EntityListeners(AuditingEntityListener.class)
public class Account
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customer;

    @Temporal(TemporalType.DATE)
    private Date expiryDate;

    @CreatedDate
    private Calendar creationDate;

    @LastModifiedDate
    private Calendar modificationDate;

    @CreatedBy
    private String createdUser;


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

    public Calendar getCreationDate()
    {
        return creationDate;
    }

    public void setCreationDate(Calendar creationDate)
    {
        this.creationDate = creationDate;
    }

    public Calendar getModificationDate()
    {
        return modificationDate;
    }

    public void setModificationDate(Calendar modificationDate)
    {
        this.modificationDate = modificationDate;
    }

    public String getCreatedUser()
    {
        return createdUser;
    }

    public void setCreatedUser(String createdUser)
    {
        this.createdUser = createdUser;
    }
}