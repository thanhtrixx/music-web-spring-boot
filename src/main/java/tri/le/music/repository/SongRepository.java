package tri.le.music.repository;

import org.springframework.data.repository.CrudRepository;
import tri.le.music.entity.SongEntity;

import java.util.List;

/**
 * Created by thanh on 3/5/2016.
 */
public interface SongRepository extends CrudRepository<SongEntity, Long> {

    List<SongEntity> findByName(String name);
}