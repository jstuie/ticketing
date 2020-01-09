package kr.co.kkalssam.admin.service;



import kr.co.kkalssam.core.domain.ticket.Actor;
import kr.co.kkalssam.core.domain.ticket.ActorRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

@RequiredArgsConstructor
public class DefaultAuthenticationProvider implements AuthenticationProvider {

    private final ActorRepository actorRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (authentication.getName() == null || authentication.getCredentials() == null) {
            return null;
        }

        if (authentication.getName().isEmpty() || authentication.getCredentials().toString().isEmpty()) {
            return null;
        }

        final Actor actor = this.actorRepository.findByUsername(authentication.getName());


        final String providedUserEmail = authentication.getName();
        final Object providedUserPassword = authentication.getCredentials();

        if (providedUserEmail.equalsIgnoreCase(actor.getUsername())
                && providedUserPassword.equals(actor.getPassword())) {
            return new UsernamePasswordAuthenticationToken(
                    actor.getUsername(),
                    actor.getPassword(),
                    Collections.singleton(new SimpleGrantedAuthority(actor.getUserRole())));
        }


        throw new UsernameNotFoundException("Invalid username or password.");
    }

    @Override
    public boolean supports(Class <?> authentication) {
        return false;
    }
}
