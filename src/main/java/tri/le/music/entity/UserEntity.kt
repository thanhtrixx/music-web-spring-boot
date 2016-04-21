package tri.le.music.entity

import java.sql.Timestamp
import javax.persistence.*

/**
 * Created by TriLe on 2016-04-21.
 */
@Entity
data class UserEntity(
        @Column(unique = true)
        var username: String = "",

        @Column(unique = true)
        var email: String = "",

        var hashPass: String = "",

        @Column(nullable = false)
        var roles: String = "",

        var name: String = "",

        var description: String = ""
) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    var createdTime: Timestamp? = null

    var lastLogin: Timestamp? = null

    var url: String = ""

    var imageUrl: String = ""

    fun login() {
        lastLogin = Timestamp(System.currentTimeMillis())
    }

    companion object {
        fun getInstance(username: String, email: String, hashPass: String, roles: String): UserEntity {
            val user = UserEntity(username, email, hashPass, roles)
            user.createdTime = Timestamp(System.currentTimeMillis())
            return user
        }
    }
}