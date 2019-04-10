package com.ktko.admin.domain.test;


import com.ktko.admin.domain.manager.service.ManagerService;
import com.ktko.admin.domain.test.dto.TestObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    ManagerService managerService;

    @GetMapping("/test")
    public String test() {


        return "test/test";
    }




    @PostMapping("validate")
    public String validate(@ModelAttribute("testObj")
        @Valid TestObj testObj, BindingResult bindingResult)  {

        System.out.println(testObj.toString());
        System.out.println(testObj.getNotNullCheck() == null);

        if(bindingResult.hasErrors()) {
            System.out.println("EXCEPTION !!!!!! HANDLER !!!!!!!");
            return "test/test";
        }


        return "manager/manager";
    }
}
