package fastcampus.projectboard.config;

import fastcampus.projectboard.domain.AuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import fastcampus.projectboard.dto.security.BoardPrincipal;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@EnableJpaAuditing
@Configuration
public class JpaConfig {

    /*@Bean
    public AuditorAware<String> auditorAware() {
        return () -> Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .filter(Authentication::isAuthenticated)
                .map(Authentication::getPrincipal)
                .map(BoardPrincipal.class::cast)
                .map(BoardPrincipal::getUsername);
    }


     */
    @Bean
    public AuditorAware<String> auditorProvider() { //등록자와 수정자를 처리해 주는 AuditorAware을 빈으로 등록
        return new AuditorAwareImpl();
    }
}
