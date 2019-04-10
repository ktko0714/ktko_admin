package com.ktko.admin.infra.authentication;

import com.ktko.admin.domain.manager.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserService {

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


//    public Authentication login() {
//
//        //return new UsernamePasswordAuthenticationToken(helloMisUserDetails, pw, helloMisUserDetails.getAuthorities(authorityList));
//        return new UsernamePasswordAuthenticationToken()
//    }

}
