package ru.jma.jmacourseservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.context.NoOpServerSecurityContextRepository;
import ru.jma.jmacourseservice.security.jwt.UserJwtAuthenticationConverter;

@EnableWebFluxSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http
                .securityContextRepository(NoOpServerSecurityContextRepository.getInstance())
                .csrf()
                .disable()
                .authorizeExchange()
                .anyExchange()
                .authenticated()
                .and()
                .oauth2ResourceServer()
                .jwt()
                .jwtAuthenticationConverter(userJwtAuthenticationConverter());
        return http.build();
    }

    @Bean
    public UserJwtAuthenticationConverter userJwtAuthenticationConverter() {
        return new UserJwtAuthenticationConverter();
    }

}
