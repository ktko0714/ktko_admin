package com.ktko.admin.domain.user;

import com.ktko.admin.infra.database.DbConnectionProperty;
import com.ktko.admin.infra.database.PersistenceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @ResponseBody
    @GetMapping("/user")
    public String test() {


        return "user";
    }
}
