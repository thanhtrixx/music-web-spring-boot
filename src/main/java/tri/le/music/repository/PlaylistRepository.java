package tri.le.music.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import tri.le.music.entity.PlaylistEntity;

/**
 * Created by thanh on 2016-04-02.
 */
@Repository
public interface PlaylistRepository extends PagingAndSortingRepository<PlaylistEntity, Long> {
}
