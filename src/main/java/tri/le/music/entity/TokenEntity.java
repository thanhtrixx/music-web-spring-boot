package tri.le.music.entity;

import tri.le.music.util.TokenUtil;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

/**
 * Created by thanh on 2016-04-02.
 */
public class TokenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String token;

    @ManyToOne
    private UserEntity owner;

    private Timestamp createTime;

    private Timestamp exprireTime;

    public static TokenEntity getInstance(UserEntity owner, int exprireMilliSeconds) {

        TokenEntity token = new TokenEntity();

        token.token = TokenUtil.generateToke();
        long currentMs = System.currentTimeMillis();
        token.createTime = new Timestamp(currentMs);
        token.exprireTime = new Timestamp(currentMs + exprireMilliSeconds);

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
