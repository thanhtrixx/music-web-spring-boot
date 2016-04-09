package tri.le.music.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tri.le.music.util.TokenUtil;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by thanh on 2016-04-02.
 */
@Entity
public class TokenEntity {
    private static final Logger log = LogManager.getLogger(TokenEntity.class);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String token;

    @ManyToOne(fetch = FetchType.EAGER)
    private UserEntity owner;

    private Timestamp createTime;

    private Timestamp exprireTime;

    public static TokenEntity getInstance(UserEntity owner, int exprireMilliSeconds) {

        TokenEntity token = new TokenEntity();

        token.token = TokenUtil.generateToke();
        token.owner = owner;
        long currentMs = System.currentTimeMillis();
        token.createTime = new Timestamp(currentMs);
        token.exprireTime = new Timestamp(currentMs + exprireMilliSeconds);
        log.debug("Create token. Owner: {}, token: {}, role: {}", owner.getUsername(), token.token, owner.getRoles());
        return token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getExprireTime() {
        return exprireTime;
    }

    public void setExprireTime(Timestamp exprireTime) {
        this.exprireTime = exprireTime;
    }
}
