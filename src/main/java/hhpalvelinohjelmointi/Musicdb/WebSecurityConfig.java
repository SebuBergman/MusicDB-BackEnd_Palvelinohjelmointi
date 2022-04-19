package hhpalvelinohjelmointi.Musicdb;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import hhpalvelinohjelmointi.Musicdb.web.UserDetailServiceImpl;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailServiceImpl userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		// Enable css when logged out, enable restful appis and add showing of db without log in aka Guest. Also index page
		.authorizeRequests().antMatchers("/css/**", "bootstrap.min.css", "/albums/**", "/songs/**", "/api/**" ,"/musiclistguest", "/index").permitAll()
		.and()
	    .authorizeRequests().anyRequest().authenticated()
	    .and()
		.cors()
		.and()
	  .formLogin()
	  		//Login page and default place for login
	  		.loginPage("/login")
	  		.defaultSuccessUrl("/musiclist", true)
	  		.permitAll()
	  		.and()
	  .logout()
	  		.permitAll();
			
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	//Some cors configuration for front-end json fetching
	@Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
			config.setAllowedOrigins(Arrays.asList("*"));
			config.setAllowedMethods(Arrays.asList("*"));
			config.setAllowedHeaders(Arrays.asList("*"));
		config.applyPermitDefaultValues();
		
		source.registerCorsConfiguration("/**", config);
		return source;
    }
}
