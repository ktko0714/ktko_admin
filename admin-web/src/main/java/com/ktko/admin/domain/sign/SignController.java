package com.ktko.admin.domain.sign;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/sign")
@Controller
public class SignController {

    @GetMapping("/in")
    public String logIn() {
        System.out.println("ktko!!!!!!!");
        return "sign/login";
    }
}
