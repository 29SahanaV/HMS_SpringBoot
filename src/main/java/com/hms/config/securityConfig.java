package com.hms.config;

import com.hms.filter.JwtFilter;
import com.hms.serviceimpl.myuserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration
@EnableWebSecurity
public class securityConfig extends WebSecurityConfigurerAdapter {


	@Autowired
	private myuserDetailsService userDetailsService;

	@Autowired
	private JwtFilter jwtFilter;

@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(userDetailsService);
}

@Bean
public PasswordEncoder getPasswordEncoder() {
	return NoOpPasswordEncoder.getInstance();
}

@Bean
@Override
public AuthenticationManager authenticationManagerBean() throws Exception {
// TODO Auto-generated method stub
return super.authenticationManagerBean();
}

@Override
protected void configure(HttpSecurity http) throws Exception {

	http.csrf().disable().authorizeRequests().antMatchers("/user/authentication").permitAll()
	.anyRequest().authenticated().and()
	.exceptionHandling().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

}


}
