package tri.le.music.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tri.le.music.entity.SongEntity;

import java.util.List;

/**
 * Created by TriLe on 3/5/2016.
 */
@RepositoryRestResource(path = "song")
public interface SongRepository extends PagingAndSortingRepository<SongEntity, Long> {

    List<SongEntity> findAll();

    List<SongEntity> findByName(String name);

    List<SongEntity> findByAlbum(String album);
}