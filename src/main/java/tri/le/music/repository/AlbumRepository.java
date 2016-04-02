package tri.le.music.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import tri.le.music.entity.AlbumEntity;

/**
 * Created by TriLe on 3/12/2016.
 */
@Repository
public interface AlbumRepository extends PagingAndSortingRepository<AlbumEntity, Long> {
}
