package tri.le.music.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import tri.le.music.security.AuthenticationTokenEntryPoint;
import tri.le.music.security.AuthenticationTokenFilter;
import tri.le.music.security.AuthenticationTokenProvider;
import tri.le.music.service.AuthService;
import tri.le.music.service.UtilService;

/**
 * Created by TriLe on 2016-04-03.
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    AuthService authService;
    @Autowired
    UtilService utilService;
    @Autowired
    AuthenticationTokenFilter authenticationTokenFilter;
    @Autowired
    AuthenticationTokenProvider authenticationTokenProvider;
    @Autowired
    AuthenticationTokenEntryPoint authenticationTokenEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling().authenticationEntryPoint(authenticationTokenEntryPoint).and()

                .csrf().ignoringAntMatchers("/api/**").and()

                .authorizeRequests().antMatchers("/api/**").access("hasAuthority('ADMIN')").and()
                .authorizeRequests().anyRequest().authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationTokenProvider);
    }

    @Bean
    public FilterRegistrationBean authorizationFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.addUrlPatterns("/api/*");
        registrationBean.setFilter(authenticationTokenFilter);
        registrationBean.setOrder(0);
        return registrationBean;
    }
}
