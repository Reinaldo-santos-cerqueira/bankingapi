package dev.reinaldosantos.bankingapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class AppConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desativa a proteção CSRF (não recomendado para produção)
                .authorizeHttpRequests(authorize -> authorize
                                .requestMatchers("/user/**").permitAll() // Permite acesso a todos os endpoints sob "/user"
                                .anyRequest().authenticated() // Exige autenticação para qualquer outra solicitação
                )
                .httpBasic(withDefaults()); // Configura a autenticação básica HTTP
        return http.build();
    }
    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}