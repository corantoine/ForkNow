package fr.simplon.spring_security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//Fichier de configuration de la sécurité de l'application (Spring Security)

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SpringSecurity(PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    //Gestion des permissions d'accès aux pages
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests((auth) -> {
            auth
                    .requestMatchers("/").permitAll()
                    .requestMatchers("/restaurant").permitAll()
                    .requestMatchers( "/register/**").anonymous()
                    .requestMatchers("/creation-resto/**").authenticated()
                    .requestMatchers("/admin").hasRole("ADMIN")
                    .requestMatchers("/profile").authenticated()
                    .requestMatchers("/css/**", "/favicon.ico", "/img/**").permitAll();
        }).formLogin(login -> login
                .defaultSuccessUrl("/", true)
                .permitAll())
        .logout(logout -> logout
                .logoutSuccessUrl("/login?success=loggedOut")
                .permitAll())
        .build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder);
    }
}
