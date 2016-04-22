@file:JvmName("TokenUtil")

package tri.le.music.util

import org.apache.logging.log4j.LogManager
import java.util.*

/**
 * Created by TriLe on 2016-04-22.
 */
private val log = LogManager.getLogger("TokenUtil")
private val TOKEN_SIZE = 36

fun generateToke() = UUID.randomUUID().toString()

fun validate(token: String) = token.length == TOKEN_SIZE
