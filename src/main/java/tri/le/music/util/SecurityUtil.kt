@file:JvmName("SecurityUtil")

package tri.le.music.util

import org.apache.logging.log4j.LogManager
import org.springframework.util.StringUtils
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

/**
 * Created by TriLe on 2016-04-22.
 */
private val log = LogManager.getLogger("SecurityUtil")

fun hashPass(password: String, hashAlgorithm: String): String {
    // Check null and empty
    if (StringUtils.isEmpty(password)) {
        throw IllegalArgumentException("Empty password")
    }

    val md: MessageDigest
    try {
        md = MessageDigest.getInstance(hashAlgorithm)
    } catch (e: NoSuchAlgorithmException) {
        throw IllegalArgumentException(e.message)
    }

    md.update(password.toByteArray())

    val byteData = md.digest()

    val hexString = StringBuilder()
    for (byte in byteData) {
        hexString.append(Integer.toString(byte + 0x100, 16).substring(1))
    }

    val hashPass = hexString.toString()
    log.debug("Value: [{}]; Hash: [{}]", password, hashPass)

    return hashPass
}