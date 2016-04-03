package tri.le.music.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * Created by TriLe on 2016-04-03.
 */
public class UserLoginDTO implements UserDetails {

    private List<? extends GrantedAuthority> authorities;
    private String username;
    private String password;

    public UserLoginDTO() {
    }

    public UserLoginDTO(String username, List<? extends GrantedAuthority> authorities, String password) {
        this.username = username;
        this.authorities = authorities;
        this.password = password;
    }

    @Override
    public List<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
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
        return true;
    }
}
