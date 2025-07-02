package s.p.r.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public BCryptPasswordEncoder passwordencoder()
	{
		return new BCryptPasswordEncoder();
	}
	@Bean
	public UserDetailService getdDetailsService()
	{
		return new UserDetailService();
	
	}
@Bean
public DaoAuthenticationProvider getAuthenticationProvider()
{
	DaoAuthenticationProvider daoauthenticationprovider=new DaoAuthenticationProvider ();
	daoauthenticationprovider.setUserDetailsService(getdDetailsService());
	daoauthenticationprovider.setPasswordEncoder( passwordencoder());
	return daoauthenticationprovider;
}
@Bean
public SecurityFilterChain filterchain(HttpSecurity http) throws Exception
{
	http.csrf().disable().authorizeHttpRequests()                
	.requestMatchers("/", "/admin","/abo","/cont","/datasave").permitAll()
	.requestMatchers("/show","/delete/{id}","/edit/{id}","updatedata").authenticated()   
	.and()
	.formLogin()                               
	.loginPage("/login")                          
	.loginProcessingUrl("/login")               
	.defaultSuccessUrl("/show",true)                 
	.permitAll();                               

return http.build();  
}
}

