package tri.le.music.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by TriLe on 3/5/2016.
 */
@RestController
@RequestMapping(path = "/api/")
public class IndexController {

//    private static final Logger log = LogManager.getLogger(IndexController.class);
//
//
//    @Autowired
//    SongRepository songRepository;
//
//    @RequestMapping(path = "/songs")
//    public List<SongEntity> index(String name) {
//        List<SongEntity> songEntity = songRepository.findAll();
//        log.info("Song info {}", songEntity);
//        return songEntity;
//    }
}
