package com.techworld.discovery.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)
            throws Exception {
        httpSecurity.csrf(csrf -> csrf.ignoringRequestMatchers("/eureka/**"));
        return httpSecurity.build();
    }

    // @Override WebSecurityConfigurerAdapter
    // public void configure(AuthenticationManagerBuilder
    // authenticationManagerBuilder) throws Exception {
    //
    // authenticationManagerBuilder.inMemoryAuthentication()
    // .withUser("eureka")
    // .password("password")
    // .authorities("USER");
    // }

    // @Override
    // public void configure(HttpSecurity httpSecurity) throws Exception{
    // httpSecurity.csrf().disable()
    // .authorizeRequests().anyRequest()
    // .authenticated().and().httpBasic();
    // }

}
