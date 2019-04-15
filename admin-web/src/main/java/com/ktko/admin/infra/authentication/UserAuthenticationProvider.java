package com.ktko.admin.infra.authentication;

import com.ktko.admin.domain.manager.entity.Manager;
import com.ktko.admin.domain.manager.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UserAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    ManagerService managerService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = (String) authentication.getCredentials();
        System.out.println("email : " + email);
        System.out.println("password : " + password);

        Manager manager =  managerService.loginManager(email, password);

        if(manager == null) {

            throw new BadCredentialsException("Login Error");
        }

        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("MANAGER"));
        System.out.println("UserAuthenticationProvider!!!!! : " + manager.toString());

        return new UsernamePasswordAuthenticationToken(manager, password, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {

        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
