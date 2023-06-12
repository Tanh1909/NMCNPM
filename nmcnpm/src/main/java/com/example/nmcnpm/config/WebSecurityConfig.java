package com.example.nmcnpm.config;

import com.example.nmcnpm.service.implement.UserDetailServiceImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                    .anyRequest().permitAll()
                    .and()
                    .formLogin()
                    .loginPage("/login")
                    .and()
                    .csrf().disable()
                    .cors().disable()
                    .httpBasic();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailServiceImp();
    }

}
