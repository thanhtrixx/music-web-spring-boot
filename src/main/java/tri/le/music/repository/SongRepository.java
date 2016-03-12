package tri.le.music.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tri.le.music.entity.SongEntity;

import java.util.List;

/**
 * Created by TriLe on 3/5/2016.
 */
@Repository
public interface SongRepository extends CrudRepository<SongEntity, Long> {

    List<SongEntity> findByName(String name);

    @Query(value = "from SongEntity where name =?1 and genre = ?2")
    List<SongEntity> findByNaG(String name, String genre);
}