package kr.co.kkalssam.admin.service;

import kr.co.kkalssam.core.domain.ticket.Actor;
import kr.co.kkalssam.core.domain.ticket.ActorRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

public class DefaultUserDetailsService implements UserDetailsService {

    private final ActorRepository actorRepository;

    public DefaultUserDetailsService(ActorRepository adminUserRepository) {
        this.actorRepository = adminUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Actor userEntity = actorRepository.findByUsername(username);

        return new User(userEntity.getUsername(),
                passwordNoEncoding(userEntity),
                Collections.singletonList(new SimpleGrantedAuthority(userEntity.getUserRole())));



    }

    private String passwordNoEncoding(Actor actor) {
        // you can use one of bcrypt/noop/pbkdf2/scrypt/sha256
        // more: https://spring.io/blog/2017/11/01/spring-security-5-0-0-rc1-released#password-encoding
        return actor.getPassword();
    }
}
