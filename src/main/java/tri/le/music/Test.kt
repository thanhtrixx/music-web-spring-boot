package tri.le.music

import tri.le.music.entity.UserEntity
import tri.le.music.service.impl.AuthService

/**
 * Created by TriLe on 2016-04-22.
 */
fun main(args: Array<String>) {
    val user = UserEntity("a", "b", "c", "1;2;3;4;5;6")

    val auth = AuthService()
    print(auth.getUserRoles(user))
}