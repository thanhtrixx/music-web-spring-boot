package tri.le.music.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import tri.le.music.entity.UserEntity;

/**
 * Created by TriLe on 2016-04-03.
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {

    @Query("FROM UserEntity WHERE username = ?1 OR email = ?1")
    public UserEntity findByUsernameOrEmail(String usernameOrEmail);
}
