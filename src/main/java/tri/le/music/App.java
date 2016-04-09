package tri.le.music;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tri.le.music.entity.AlbumEntity;
import tri.le.music.entity.SongEntity;
import tri.le.music.entity.TokenEntity;
import tri.le.music.entity.UserEntity;
import tri.le.music.repository.*;

/**
 * Created by TriLe on 3/5/2016.
 */
@SpringBootApplication
public class App {

    private static final Logger log = LogManager.getLogger(App.class);


    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner demo(
            SongRepository songRepository,
            AlbumRepository albumRepository,
            ArtistRepository artistRepository,
            UserRepository userRepository,
            TokenRepositoty tokenRepositoty
    ) {
        return (args) -> {
            // save albums
            AlbumEntity sauTatCa = new AlbumEntity("Sau Tất Cả");
            AlbumEntity tamSuVoiNguoiLa = new AlbumEntity("Tâm Sự Với Người Lạ");
            albumRepository.save(sauTatCa);
            albumRepository.save(tamSuVoiNguoiLa);

            // save songs
            songRepository.save(new SongEntity("Sau Tất Cả", sauTatCa));
            songRepository.save(new SongEntity("Tâm Sự Với Người Lạ", tamSuVoiNguoiLa));
            songRepository.save(new SongEntity("Nếu Em Còn Tồn Tại"));
            songRepository.save(new SongEntity("Khi Người Mình Yêu Khóc"));
            songRepository.save(new SongEntity("Nếu Ngày Ấy"));
            songRepository.save(new SongEntity("Tình Yêu Chắp Vá"));
            songRepository.save(new SongEntity("Anh Sẽ Tốt Mà"));

            // save users
            UserEntity user = UserEntity.getInstance("user1", "user1", "6db587510d5f7b2cfde0fbff68314c89a0dcd8339b40c8434a101aaac9a89bd0", "USER");
            UserEntity admin = UserEntity.getInstance("admin", "admin", "6db587510d5f7b2cfde0fbff68314c89a0dcd8339b40c8434a101aaac9a89bd0", "USER;ADMIN");
            userRepository.save(user);
            userRepository.save(admin);

            // save token
            tokenRepositoty.save(TokenEntity.getInstance(admin, 365 * 24 * 60 * 60 * 1000));
            tokenRepositoty.save(TokenEntity.getInstance(admin, 365 * 24 * 60 * 60 * 1000));
        };
    }
}
