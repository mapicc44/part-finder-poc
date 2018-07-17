package com.halfords.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class HalfordsPartFinderSecurityConfig extends WebSecurityConfigurerAdapter {

	// @Autowired private AuthenticationEntryPoint authEntryPoint;
	
	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
	
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
    }
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
				.antMatchers("/swagger-ui.html", "/swagger-resources/**",  "/webjars/**").permitAll()
				.antMatchers("/configuration/ui", "/configuration/security", "/v2/api-docs" ).permitAll()
				.anyRequest().authenticated()
				.and()
			.httpBasic()
			// .authenticationEntryPoint(authEntryPoint)
		;
	}
}
