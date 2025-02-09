package com.bank.system.demo.util;

import com.bank.system.demo.dto.UserDTO;
import com.bank.system.demo.services.UserService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    private final UserService userService;

    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return UserDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO userDTO = (UserDTO) target;
        if (userService.findByUsername(userDTO.getUsername()).isPresent()){
            errors.rejectValue("username", "","Username is busy!");
        }

    }
}
