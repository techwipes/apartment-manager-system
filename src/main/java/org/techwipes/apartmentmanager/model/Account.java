package org.techwipes.apartmentmanager.model;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "owner_name")
    private String ownerName;
    @Column(name = "owner_last_name")
    private String ownerLastName;
    @Column(name = "balance")
    private Double balance;
    @Column(name = "account_number")
    private Integer accountNumber;
    @Column(name = "apartment_number")
    private Integer apartmentNumber;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getAccount_number() {
        return accountNumber;
    }

    public void setAccount_number(Integer account_number) {
        this.accountNumber = account_number;
    }

    public Integer getApartment_number() {
        return apartmentNumber;
    }

    public void setApartment_number(Integer apartment_number) {
        this.apartmentNumber = apartment_number;
    }


}
