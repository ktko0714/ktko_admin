package com.ktko.admin.domain.sign

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/sign")
class SignController {

    @GetMapping("/in")
    fun logIn(): String {
        println("Kotlin Success")

        return "sign/login"
    }
}