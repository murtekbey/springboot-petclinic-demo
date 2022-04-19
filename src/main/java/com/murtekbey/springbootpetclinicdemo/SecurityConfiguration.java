package com.murtekbey.springbootpetclinicdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
public class SecurityConfiguration extends AbstractSecurityConfiguration {

  private final UserDetailsService userDetailsService;

  @Autowired
  public SecurityConfiguration(UserDetailsService userDetailsService) {
    this.userDetailsService = userDetailsService;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers(
            "/**/favicon.ico", "/css/**", "/js/**", "/images/**", "/webjars/**", "/login.html")
        .permitAll();
    http.authorizeRequests().antMatchers("/actuator/**").access("hasRole('ADMIN')");
    http.authorizeRequests().anyRequest().authenticated();
    http.formLogin()
        .loginPage("/login.html")
        .loginProcessingUrl("/login")
        .failureUrl("/login.html?loginFailed=true");
    http.rememberMe().userDetailsService(userDetailsService);
  }
}
