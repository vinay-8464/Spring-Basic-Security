package com.example.demo.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	//Below code for basic authentication
	//The main disadvantage of "basic Authentication" is that.. we need to provide username and password every time
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers(HttpMethod.GET,"/api/**").permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();				
	}
	
	@Override
	protected UserDetailsService userDetailsService() {
		UserDetails vinay= User.builder().username("vinay").password("Cracker@8464").roles("USER").build();
		UserDetails admin= User.builder().username("admin").password("admin").roles("ADMIN").build();
		return new InMemoryUserDetailsManager(vinay,admin);
	}
}
