package com.bank.system.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BankController {
    @GetMapping("/main")
    public String mainPage(){
        return "bank/main";
    }
}
