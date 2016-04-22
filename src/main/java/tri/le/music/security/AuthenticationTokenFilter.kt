package tri.le.music.security

import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import tri.le.music.service.impl.AuthService
import tri.le.music.util.validate
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created by TriLe on 2016-04-22.
 */
@Component
class AuthenticationTokenFilter : OncePerRequestFilter() {

    @Autowired
    lateinit var authService: AuthService

    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        val token = request.getHeader("token")

        if (validate(token)) {
            // determine the user based on the (already validated) token
            val userDetails = authService.loadUserByToken(token)

            if (userDetails != null) {

                val authentication = UsernamePasswordAuthenticationToken(token, userDetails, userDetails.authorities) //this.authenticationProvider.authenticate(token);
                // set the authentication into the SecurityContext
                SecurityContextHolder.getContext().authentication = authentication
            }
        }
        // next the filter chain
        filterChain.doFilter(request, response)
    }

    companion object {

        private val log = LogManager.getLogger(AuthenticationTokenFilter::class.java)
    }
}
