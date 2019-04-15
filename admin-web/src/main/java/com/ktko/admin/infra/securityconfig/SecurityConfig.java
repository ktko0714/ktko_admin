package com.ktko.admin.infra.securityconfig;

import com.ktko.admin.infra.authentication.UserAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserAuthenticationProvider userAuthenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/sign/in").permitAll()
            .antMatchers("/manager*").hasAuthority("MANAGER")
            .antMatchers("/test*").hasAuthority("ADMIN")
            .anyRequest().authenticated()
            .and()
            .formLogin().loginPage("/sign/in")
            .usernameParameter("email")
            .passwordParameter("password")
            .loginProcessingUrl("/sign/processing")
            .defaultSuccessUrl("/manager/manager")
            .and()
            .logout().logoutUrl("/logout").logoutSuccessUrl("/sign/in")
            .and()
            .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(userAuthenticationProvider);
    }
}
