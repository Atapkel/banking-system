package com.bank.system.demo.controller;

import com.bank.system.demo.dto.UserDTO;
import com.bank.system.demo.services.UserService;
import com.bank.system.demo.util.UserValidator;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private final UserService userService;
    private final UserValidator userValidator;

    public AuthController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
    @GetMapping("/login")
    public String login(){
        return "auth/login";
    }
    @GetMapping("/register")
    public String registerPage(@ModelAttribute("user")UserDTO userDTO){
            return "auth/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user")@Valid UserDTO userDTO,
                           BindingResult bindingResult){
        userValidator.validate(userDTO,bindingResult);
        if (bindingResult.hasErrors()){
            return "auth/register";
        }
        System.out.println(userDTO);
        userService.save(userDTO);
        return "auth/login";
    }

    @GetMapping("/logout")
    public String logout(){
        return "auth/login";
    }
}
