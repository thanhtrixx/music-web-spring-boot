package tri.le.music.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import tri.le.music.entity.TokenEntity;

/**
 * Created by TriLe on 2016-04-03.
 */
@Repository
public interface TokenRepositoty extends PagingAndSortingRepository<TokenEntity, Long> {

    public TokenEntity findByToken(String token);
}