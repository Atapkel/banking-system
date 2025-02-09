package com.bank.system.demo.repositories;

import com.bank.system.demo.models.BankUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<BankUser, Long> {
    Optional<BankUser> findByUsername(String username);
}
