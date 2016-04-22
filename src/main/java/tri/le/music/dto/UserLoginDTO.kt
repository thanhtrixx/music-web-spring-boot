package tri.le.music.dto

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

/**
 * Created by TriLe on 2016-04-22.
 */
class UserLoginDTO : UserDetails {
    private var username: String = ""
    private var password: String = ""
    private var authorities: List<out GrantedAuthority>? = null

    constructor(username: String = "", password: String = "", authorities: List<out GrantedAuthority>? = null) {
        this.username = username
        this.password = password
        this.authorities = authorities
    }

    override fun getUsername() = username
    override fun getPassword() = password
    override fun getAuthorities() = authorities
    override fun isAccountNonExpired() = true
    override fun isAccountNonLocked() = true
    override fun isCredentialsNonExpired() = true
    override fun isEnabled() = true
}