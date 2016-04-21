package tri.le.music.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import tri.le.music.entity.SongListEntity;

/**
 * Created by TriLe on 2016-04-02.
 */
@Repository
public interface PlaylistRepository extends PagingAndSortingRepository<SongListEntity, Long> {
}
