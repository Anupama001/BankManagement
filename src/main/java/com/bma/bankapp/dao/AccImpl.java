package com.bma.bankapp.dao;

import com.bma.bankapp.Service.AccService;
import com.bma.bankapp.entity.Account;
import com.bma.bankapp.repo.AccRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccImpl implements AccService {
    @Autowired
    AccRepo accRepo;
    @Override
    public Account createAcc(Account account){
        Account saveAcc=accRepo.save(account);
        return saveAcc;
    }

    @Override
    public Account getAccByAccnum(Long accNum) {
        Optional<Account> account=accRepo.findById(accNum);
        if (account.isEmpty()){
            throw new RuntimeException("Account number is invalid");
        }
        return account.get();
    }

    @Override
    public List<Account> getAllAcc() {
        List<Account> accounts=accRepo.findAll();
        return accounts;
    }

    @Override
    public Account deposit(Long accNum, Double amount) {
        Optional<Account> account=accRepo.findById(accNum);
        if (account.isEmpty()){
            throw new RuntimeException("Account number is invalid");
        }
        Account account1=account.get();
        account1.setAcc_bal(account1.getAcc_bal()+amount);
        accRepo.save(account1);
        return account1;
    }

    @Override
    public Account withdraw(Long accNum, Double amount) {
        Optional<Account> account=accRepo.findById(accNum);
        if (account.isEmpty()){
            throw new RuntimeException("Account number is invalid");
        }
        Account account1=account.get();
        account1.setAcc_bal(account1.getAcc_bal()-amount);
        accRepo.save(account1);
        return account1;
    }

    @Override
    public void closeAcc(Long accNum) {
        Optional<Account> account=accRepo.findById(accNum);
        if (account.isEmpty()){
            throw new RuntimeException("Account number is invalid");
        }
        accRepo.deleteById(account.get().getAcc_num());
    }
}
