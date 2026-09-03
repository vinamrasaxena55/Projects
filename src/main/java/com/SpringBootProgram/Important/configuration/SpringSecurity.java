package com.SpringBootProgram.Important.configuration;

import com.SpringBootProgram.Important.Service.CustomUserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
//@Profile("dev") //tells spring run this for development phase
public class SpringSecurity {

    @Autowired
    private CustomUserDetailServiceImpl userrDetailsService;
    // injecting our custom UserDetailsService which loads users from database

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // hum http requests se filter kr sakte hain ki kis type
        // ki request ko authenticate krna hai
        System.out.println(">>> SECURITY CONFIG LOADED <<<");

        http
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers(HttpMethod.POST,"/user").permitAll()//this allow making new user without login
                                .requestMatchers("/journal/**").authenticated()
                                .requestMatchers("/user/**").authenticated()
                                .requestMatchers("/admin/**").hasRole("ADMIN")//means authenticated
                        //all admin related apis will be authenticated by users whose role is admin
                                // for giving endpoint ** means anything after that

                                .anyRequest().permitAll()
                        // all other endpoints accessible without login
                )

                .httpBasic(Customizer.withDefaults())
                // enables Basic Authentication

                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // stateless for basic authentication

                .csrf(csrf -> csrf.disable());
        // disables CSRF for Postman testing

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
        // password in hashed form so other cant see
    }
}