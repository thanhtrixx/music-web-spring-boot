package tri.le.music.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import tri.le.music.dto.UserLoginDTO
import tri.le.music.entity.UserEntity
import tri.le.music.repository.TokenRepositoty
import tri.le.music.repository.UserRepository

/**
 * Created by TriLe on 2016-04-22.
 */
@Service
class AuthService : UserDetailsService {

    @Autowired
    lateinit var userRepository: UserRepository
    @Autowired
    lateinit var tokenRepositoty: TokenRepositoty

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails? {
        val user = userRepository.findByUsernameOrEmail(username) ?: return null

        return getUserRoles(user)
    }

    fun loadUserByToken(token: String): UserDetails? {
        val owner = tokenRepositoty.findByToken(token)?.owner ?: return null

        return getUserRoles(owner)
    }

    fun getUserRoles(user: UserEntity): UserDetails {
        val roles = user.roles.split(";").distinct()
        val authorities = roles.map { r -> SimpleGrantedAuthority(r) }

        return UserLoginDTO(user.username, user.hashPass, authorities)
    }
}
