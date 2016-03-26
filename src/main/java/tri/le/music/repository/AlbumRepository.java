package tri.le.music.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tri.le.music.entity.AlbumEntity;

/**
 * Created by TriLe on 3/12/2016.
 */
@RepositoryRestResource(path = "albums")
public interface AlbumRepository extends PagingAndSortingRepository<AlbumEntity, Long> {
}
