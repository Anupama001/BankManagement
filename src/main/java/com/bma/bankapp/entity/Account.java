package com.bma.bankapp.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long acc_num;
    @Column
    private String acc_name;
    @Column
    private Double acc_bal;

    public Account() {
    }

    public Account(String acc_name, Double acc_bal) {
        this.acc_name = acc_name;
        this.acc_bal=acc_bal;
    }

    public Long getAcc_num() {
        return acc_num;
    }

    public void setAcc_num(Long acc_num) {
        this.acc_num = acc_num;
    }

    public String getAcc_name() {
        return acc_name;
    }

    public void setAcc_name(String acc_name) {
        this.acc_name = acc_name;
    }

    public Double getAcc_bal() {
        return acc_bal;
    }

    public void setAcc_bal(Double acc_bal) {
        this.acc_bal = acc_bal;
    }
}
