package com.bma.bankapp.controller;

import com.bma.bankapp.Service.AccService;
import com.bma.bankapp.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccController {
    @Autowired
    AccService accService;

    @PostMapping("/create")
    public ResponseEntity<Account> createAcc(@RequestBody Account account){
        Account createAcc=accService.createAcc(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(createAcc);
    }
    @GetMapping("/{accNum}")
    public Account getAccByNum(@PathVariable Long accNum){
        Account account=accService.getAccByAccnum(accNum);
        return account;
    }
    @GetMapping("/getAll")
    public List<Account> getAllAcc(){
        return accService.getAllAcc();
    }
    @PutMapping("/deposit/{accNum}/{amount}")
    public Account depositAcc(@PathVariable Long accNum,@PathVariable Double amount){
        Account account=accService.deposit(accNum,amount);
        return account;
    }
    @PutMapping("/withdraw/{accNum}/{amount}")
    public Account withdrawAcc(@PathVariable Long accNum,@PathVariable Double amount){
        Account account=accService.withdraw(accNum,amount);
        return account;
    }
    @DeleteMapping("/{accNum}")
    public ResponseEntity<String> deleteAcc(@PathVariable Long accNum){
        accService.closeAcc(accNum);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Account Deleted");
    }
}
