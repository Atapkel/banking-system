package com.bank.system.demo.services;

import com.bank.system.demo.models.BankUser;

import com.bank.system.demo.repositories.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<BankUser> user = userRepository.findByUsername(username);
        if (user.isPresent()){
            var obj = user.get();
            return User.builder()
                    .username(obj.getUsername())
                    .password(obj.getPassword())
                    .build();
        }else throw new UsernameNotFoundException("Username not found!");
    }
}
