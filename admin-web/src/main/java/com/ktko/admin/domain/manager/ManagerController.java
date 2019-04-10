package com.ktko.admin.domain.manager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/manager")
public class ManagerController {

    @ResponseBody
    @GetMapping("/test")
    public String test() {

        return "manager";
    }

    @GetMapping("/manager")
    public String manager(Model model) {
        model.addAttribute("name", "ktk1o");

        return "manager/manager";
    }
}
