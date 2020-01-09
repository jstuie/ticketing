package kr.co.kkalssam.core.domain.ticket;

import kr.co.kkalssam.core.enumeration.YesOrNo;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
/**
 * Created by jslim on 2020/01/06.
 */
@Entity
@Data
public class Actor implements UserDetails{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ActorKey")
    private Integer adminUserKey;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "UserRole")
    private String userRole;

    @Column(name = "IsEnable")
    @Enumerated(EnumType.STRING)
    private YesOrNo isEnable;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(userRole));
    }

    @Override
    public String getPassword() {
        return  "{noop}"+password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return (isEnable == YesOrNo.Y);
    }
}
