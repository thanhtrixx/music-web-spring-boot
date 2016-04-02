package tri.le.music.entity.base;

/**
 * Created by TriLe on 3/12/2016.
 */
public class HumanEntity extends PublicInfoEntity {

    private String name;

    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
