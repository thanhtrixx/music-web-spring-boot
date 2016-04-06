package tri.le.music.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import tri.le.music.service.AuthService;
import tri.le.music.util.TokenUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by TriLe on 2016-04-03.
 */
@Component
public class AuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    AuthService authService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = request.getHeader("token");

        if (TokenUtil.validate(token)) {
            // determine the user based on the (already validated) token
            UserDetails userDetails = authService.loadUserByToken(token);

            if (userDetails != null) {

                Authentication authentication = new UsernamePasswordAuthenticationToken(token, userDetails, userDetails.getAuthorities()); //this.authenticationProvider.authenticate(token);
                // set the authentication into the SecurityContext
                SecurityContextHolder.getContext().setAuthentication(authManager.authenticate(authentication));
            }
        }
        // next the filter chain
        filterChain.doFilter(request, response);
    }
}
