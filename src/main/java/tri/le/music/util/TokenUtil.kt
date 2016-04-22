@file:JvmName("TokenUtil")

package tri.le.music.util

import org.apache.logging.log4j.LogManager
import java.util.*

/**
 * Created by TriLe on 2016-04-22.
 */
private val TOKEN_SIZE = 36
private val log = LogManager.getLogger("TokenUtil")

public fun generateToke(): String {
    return UUID.randomUUID().toString()
}

public fun validate(token: String): Boolean {
    if (token.length == TOKEN_SIZE) return true

    return false
}
