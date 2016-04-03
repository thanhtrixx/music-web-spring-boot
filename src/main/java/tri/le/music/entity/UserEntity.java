package tri.le.music.entity;

import tri.le.music.entity.base.HumanEntity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by thanh on 2016-04-02.
 */
@Entity
public class UserEntity extends HumanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    private String hashPass;

    private Timestamp createTime;

    private Timestamp lastLogin;

    @Column(nullable = false)
    private String roles;

    public UserEntity() {
    }

    public static UserEntity getInstance(String username, String email, String hashPass, String roles) {
        UserEntity user = new UserEntity();

        user.username = username;
        user.email = email;
        user.hashPass = hashPass;
        user.roles = roles;
        user.createTime = new Timestamp(System.currentTimeMillis());

        return user;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashPass() {
        return hashPass;
    }

    public void setHashPass(String hashPass) {
        this.hashPass = hashPass;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
