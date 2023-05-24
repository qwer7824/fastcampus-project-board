package fastcampus.projectboard.domain;

import org.springframework.data.domain.AuditorAware;
import fastcampus.projectboard.dto.security.BoardPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication.isAuthenticated()==false){
            System.out.println("in not authenticated");
        }
        if (authentication.getPrincipal()=="anonymousUser") { //case:회원 가입
            Optional<String> s =Optional.of("sdf");
            return s;
        }else{
            BoardPrincipal boardPrincipal=(BoardPrincipal) authentication.getPrincipal();
            return Optional.of(boardPrincipal.getUsername());
        }
    }
}