/**
 * @author tehli - lbellison
 * CIS175 - Fall 2023
 * Nov 5, 2023
 */
package dmacc.beans;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author LILY ELLISON - LBELLISON
 * CIS175 - FALL 2023
 * Nov 5, 2023
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	@Autowired
	private DataSource dataSource;
	
	@Bean
	UserDetailsService userDetailsService() {
		return new CustomUserDetailsService();
	}
	
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

    @Bean
    DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
	}
	
    @Bean
    public AuthenticationManager authenticationManager(
    		AuthenticationConfiguration authConfig) throws Exception {
    	return authConfig.getAuthenticationManager();
    }
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.authenticationProvider(authenticationProvider());
//        http.authorizeRequests(requests -> requests.requestMatchers("/index").permitAll()
//                .requestMatchers("/employees").authenticated()
//                .anyRequest().permitAll())
//                .formLogin(login -> login
//                        .loginPage("/index")
//                        .usernameParameter("username")
//                        .defaultSuccessUrl("/employees")
//                        .permitAll())
//                .logout(logout -> logout.logoutSuccessUrl("/").permitAll());
//        http.headers().frameOptions().sameOrigin();
//        
//        return http.build();
//        
//    }
	
	
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().requestMatchers("/images/**", "/js/**", "/webjars/**");
	}
}
