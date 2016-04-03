package tri.le.music.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tri.le.music.dto.UserLoginDTO;
import tri.le.music.entity.TokenEntity;
import tri.le.music.entity.UserEntity;
import tri.le.music.repository.TokenRepositoty;
import tri.le.music.repository.UserRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by thanh on 2016-04-03.
 */
@Service
public class AuthService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    TokenRepositoty tokenRepositoty;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsernameOrEmail(username);

        if (user == null)
            return null;

        return getUserDetails(user);
    }

    public UserDetails loadUserByToken(String token) {
        TokenEntity tokenEntity = tokenRepositoty.findByToken(token);

        if (token == null)
            return null;

        return getUserDetails(tokenEntity.getOwner());
    }

    private UserDetails getUserDetails(UserEntity user) {
        String[] roles = user.getRoles().split(";");

        List<GrantedAuthority> authorities = Arrays.stream(roles).distinct()
                .map(s -> new SimpleGrantedAuthority(s)).collect(Collectors.toList());

        return new UserLoginDTO(user.getUsername(), authorities, user.getHashPass());
    }
}
