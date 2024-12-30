package com.bma.bankapp.repo;

import com.bma.bankapp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccRepo extends JpaRepository<Account , Long> {
}
