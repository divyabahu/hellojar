package com.svit.hello1.helloExample1;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity 
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(AuthenticationManagerBuilder auth)  throws Exception {
		auth.inMemoryAuthentication()
		.withUser("Bahu")
		.password("Bahu199")
		.roles("user")
		.and()
		.withUser("Srreni")
		.password("Srreni@1234")
		.roles("admin");
	}
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
		
	}
	@Override
	protected void configure (HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/admin").hasAnyRole("admin","user")
		.antMatchers("/printHello").permitAll()
		.antMatchers("/user").hasRole("user")
		.and().formLogin();
	}
	

}
