package tri.le.music.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tri.le.music.entity.SongEntity;
import tri.le.music.repository.SongRepository;

import java.util.List;

/**
 * Created by TriLe on 3/5/2016.
 */
@RestController
@RequestMapping(path = "/api/")
public class IndexController {

    private static final Logger log = LogManager.getLogger(IndexController.class);


    @Autowired
    SongRepository songRepository;

    @RequestMapping(path = "/songs")
    public List<SongEntity> index(String name) {
        List<SongEntity> songEntity = songRepository.findAll();
        log.info("Song info {}", songEntity);
        return songEntity;
    }
}
