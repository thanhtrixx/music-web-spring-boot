package tri.le.music;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tri.le.music.entity.AlbumEntity;
import tri.le.music.entity.SongEntity;
import tri.le.music.repository.AlbumRepository;
import tri.le.music.repository.ArtistRepository;
import tri.le.music.repository.SongRepository;

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
            ArtistRepository artistRepository
    ) {
        return (args) -> {
            // save Album
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
        };
    }
}
