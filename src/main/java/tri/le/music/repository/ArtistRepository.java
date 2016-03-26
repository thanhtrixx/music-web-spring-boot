package tri.le.music.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tri.le.music.entity.ArtistEntity;

/**
 * Created by TriLe on 3/12/2016.
 */
@RepositoryRestResource(path = "artist")
public interface ArtistRepository extends PagingAndSortingRepository<ArtistEntity, Long> {
}
