package tri.le.music.entity;

import tri.le.music.entity.base.PublicInfoEntity;

import javax.persistence.*;

/**
 * Created by TriLe on 3/12/2016.
 */
@Entity
public class PlaylistEntity extends PublicInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    private String imgUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}

