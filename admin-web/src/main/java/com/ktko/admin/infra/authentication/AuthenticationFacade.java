package com.ktko.admin.infra.authentication;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade {
    public Authentication getAuthentication() {

        return SecurityContextHolder.getContext().getAuthentication();
    }

}

/**

 @Override
 public Authentication getAuthentication() {
 return SecurityContextHolder.getContext().getAuthentication();
 }

 public String getUsername() {
 HelloMisUserDetails helloMisUserDetails  = (HelloMisUserDetails) getAuthentication().getPrincipal();
 return helloMisUserDetails.getPersonName();
 }

 public String getUserId() {
 if(getAuthentication() != null) return getAuthentication().getName();
 else return null;
 }

 public List<String> getAuthorityList() {
 List<String> list = new ArrayList<>();

 Authentication authentication = getAuthentication();
 Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) authentication.getAuthorities();

 for(GrantedAuthority grantedAuthority : authorities) {
 list.add(grantedAuthority.getAuthority());
 }

 return list;
 }

 **/