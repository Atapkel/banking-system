package com.bank.system.demo.services;

import com.bank.system.demo.dto.UserDTO;
import com.bank.system.demo.models.BankUser;
import com.bank.system.demo.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
   private final UserRepository userRepository;
   private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public Optional<BankUser> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public void save(UserDTO userDTO){
        BankUser user = new BankUser();
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setUsername(userDTO.getUsername());
        user.setRole("USER");
        userRepository.save(user);
    }

}
