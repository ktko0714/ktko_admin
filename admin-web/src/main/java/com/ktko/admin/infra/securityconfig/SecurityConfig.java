package com.ktko.admin.infra.securityconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/sign/in").permitAll()
            .antMatchers("/manager*").hasAuthority("MANAGER")
            .antMatchers("/test*").hasAuthority("ADMIN")
            .anyRequest().authenticated()
            .and()
            .formLogin().loginPage("/sign/in").defaultSuccessUrl("/manager/manager")
            .and()
            .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {

    }
}
