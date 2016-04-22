package tri.le.music.security

import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.stereotype.Component

/**
 * Created by TriLe on 2016-04-22.
 */
@Component
class AuthenticationTokenProvider : AuthenticationProvider {

    @Throws(AuthenticationException::class)
    override fun authenticate(authentication: Authentication): Authentication {
        return authentication
    }

    override fun supports(authentication: Class<*>): Boolean {
        return true
    }
}