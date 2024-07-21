package tranquiltybackend.tranquiltybackend.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class MySecurityConfig {
    @Autowired
    private JwtAuthenticationEntryPoint point;
    @Autowired
    private JwtAuthenticationFilter filter;


	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.csrf(csrf -> csrf.disable())
        .authorizeRequests().
        requestMatchers("/generate-token").permitAll().requestMatchers("/user/").permitAll().requestMatchers("/user/email/{email}").permitAll()
        .requestMatchers("/user/email/otp/{otp}/{username}").permitAll()
        .requestMatchers("/user/password-change").permitAll()

        .anyRequest()
        .authenticated()
        .and().exceptionHandling(ex -> ex.authenticationEntryPoint(point))
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
return http.build();
	}
	
}
