package tri.le.music;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tri.le.music.entity.SongEntity;
import tri.le.music.repository.SongRepository;

/**
 * Created by thanh on 3/5/2016.
 */
@SpringBootApplication
public class App {

    private static final Logger log = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner demo(SongRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new SongEntity("Bauer"));
            repository.save(new SongEntity("O'Brian"));
            repository.save(new SongEntity("Bauer"));
            repository.save(new SongEntity("Palmer"));
            repository.save(new SongEntity("Dessler"));
        };
    }
}
