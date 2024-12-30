package com.bma.bankapp.Service;

import com.bma.bankapp.entity.Account;

import java.util.List;

public interface AccService {
    public Account createAcc(Account account);
    public  Account getAccByAccnum(Long accNum);
    public List<Account> getAllAcc();
    public Account deposit(Long accNum, Double amount);
    public Account withdraw(Long accNum, Double amount);
    public void closeAcc(Long accNum);
}
