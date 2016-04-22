package tri.le.music.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import tri.le.music.util.hashPass

/**
 * Created by TriLe on 2016-04-22.
 */
@Service
class UtilService {
    @Value("\${app.hash-algorithm}")
    private val hashAlgorithm: String = "SHA-256"
    @Value("\${app.hash-secret-key}")
    private val hashSecretKey: String? = "this-is-secret"

    fun hashPass(password: String): String {
        val sb = StringBuilder(hashSecretKey)
        sb.append(password)
        return hashPass(sb.toString(), hashAlgorithm)
    }
}
