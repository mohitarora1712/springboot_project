package com.lpu.test2.config;

import java.util.List;

import org.springframework.context.annotation.*;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.*;

import com.lpu.test2.entity.AppUser;
import com.lpu.test2.repository.UserRepository;

@Configuration
@EnableMethodSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
        .cors(Customizer.withDefaults())
        .csrf(csrf -> csrf.disable())

        .authorizeHttpRequests(auth -> auth

                // swagger
                .requestMatchers(
                        "/swagger-ui/**",
                        "/v3/api-docs/**"
                ).permitAll()

                // actuator
                .requestMatchers("/actuator/**").permitAll()

                // allow creating users initially
                .requestMatchers("/users/**").permitAll()

                // ADMIN only
                .requestMatchers(HttpMethod.POST,"/students/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT,"/students/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE,"/students/**").hasRole("ADMIN")

                // ADMIN + USER
                .requestMatchers(HttpMethod.GET,"/students/**")
                .hasAnyRole("ADMIN","USER")

                .anyRequest().authenticated()
        )

        .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // DATABASE LOGIN
    @Bean
    public UserDetailsService userDetailsService(UserRepository repo){

        return username -> {

            AppUser user = repo.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));

            return User.builder()
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .roles(user.getRole())
                    .build();
        };
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource(){

        CorsConfiguration config = new CorsConfiguration();

        config.setAllowedOriginPatterns(List.of("*"));
        config.setAllowedMethods(List.of("GET","POST","PUT","DELETE"));
        config.setAllowedHeaders(List.of("*"));

        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", config);

        return source;
    }
}