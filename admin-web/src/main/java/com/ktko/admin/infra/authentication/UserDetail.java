package com.ktko.admin.infra.authentication;

import com.ktko.admin.domain.manager.entity.Manager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetail implements UserDetails {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private List<? extends GrantedAuthority> authorities;

    public UserDetail(Manager manager) {
        this.id = manager.getId();
        this.name = manager.getName();
        this.email = manager.getEmail();
        this.password = manager.getPassword();
        this.phoneNumber = manager.getPhoneNumber();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public Collection<? extends GrantedAuthority> getAuthorities(List<String> authorityList) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        for(String authority : authorityList) {

            authorities.add(new SimpleGrantedAuthority(authority));
        }

        return authorities;
    }

    @Override
    public String getPassword() {

        return this.password;
    }

    @Override
    public String getUsername() {

        return this.name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
