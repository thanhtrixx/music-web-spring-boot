package tri.le.music.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import tri.le.music.security.AuthenticationTokenFilter;
import tri.le.music.security.AuthenticationTokenProvider;
import tri.le.music.service.AuthService;
import tri.le.music.service.UtilService;

/**
 * Created by TriLe on 2016-04-03.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    AuthService authService;
    @Autowired
    UtilService utilService;
    @Autowired
    AuthenticationTokenFilter authenticationTokenFilter;
    @Autowired
    AuthenticationTokenProvider authenticationTokenProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/**").permitAll();
        http.addFilterBefore(authenticationTokenFilter, BasicAuthenticationFilter.class);
    }

    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return null;
            }
        });
        auth.authenticationProvider(authenticationTokenProvider);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return utilService.hashPass(rawPassword.toString());
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return encode(rawPassword).equals(encodedPassword);
            }
        };

        return encoder;
    }

//    @Bean
//    public FilterRegistrationBean authorizationFilter() {
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        registrationBean.addUrlPatterns("/api/*");
//        registrationBean.setFilter(authenticationTokenFilter);
//        registrationBean.setOrder(1);
//        return registrationBean;
//    }
}
