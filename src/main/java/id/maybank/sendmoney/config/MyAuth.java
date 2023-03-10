package id.maybank.sendmoney.config;

import id.maybank.sendmoney.service.CustomerUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MyAuth {

    @Autowired
    private CustomerUserDetailService customerUserDetailService;

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(customerUserDetailService);
        authProvider.setPasswordEncoder(bCryptPasswordEncoder());
        return authProvider;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests().requestMatchers("/bank").hasAnyAuthority("ADMIN", "SUPER");
        httpSecurity.authorizeHttpRequests().requestMatchers("/rekening").hasAnyAuthority("CUSTOMER SERVICE", "SUPER");
        httpSecurity.authorizeHttpRequests().requestMatchers("/rekening/*").hasAnyAuthority("CUSTOMER SERVICE", "SUPER");
        httpSecurity.authorizeHttpRequests().requestMatchers("/transfer").hasAnyAuthority("OPERATOR", "SUPER");
        httpSecurity.authorizeHttpRequests().requestMatchers("/histories").hasAnyAuthority("OPERATOR", "SUPER");

        httpSecurity.authorizeHttpRequests().anyRequest().authenticated();
        httpSecurity.authorizeHttpRequests().and().formLogin();

        return httpSecurity.build();
    }

}
