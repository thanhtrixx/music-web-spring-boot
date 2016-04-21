package tri.le.music.entity

import org.apache.logging.log4j.LogManager
import tri.le.music.util.TokenUtil
import java.sql.Timestamp
import javax.persistence.*

/**
 * Created by TriLe on 2016-04-21.
 */
@Entity
class TokenEntity(

        @ManyToOne(fetch = FetchType.EAGER)
        var owner: UserEntity? = null
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    var token: String? = null

    var createdTime: Timestamp? = null

    var exprireTime: Timestamp? = null

    companion object {
        private val log = LogManager.getLogger(TokenEntity::class.java)
        fun getInstance(owner: UserEntity, exprireMilliSeconds: Int): TokenEntity {
            val token = TokenEntity(owner)
            token.token = TokenUtil.generateToke()
            val currentMs = System.currentTimeMillis()
            token.createdTime = Timestamp(currentMs)
            token.exprireTime = Timestamp(currentMs + exprireMilliSeconds)
            log.debug("Create token. Owner: {}, token: {}, role: {}", owner.username, token.token, owner.roles)
            return token
        }
    }
}