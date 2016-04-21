package tri.le.music.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tri.le.music.util.SecurityUtil;

/**
 * Created by TriLe on 2016-04-02.
 */
@Service
public class UtilService {

    @Value("${app.hash-algorithm}")
    private String hashAlgorithm;
    @Value("${app.hash-secret-key}")
    private String hashSecretKey;

    public String hashPass(String password) {
        StringBuilder sb = new StringBuilder(hashSecretKey);
        sb.append(password);
        return SecurityUtil.hashPass(sb.toString(), hashAlgorithm);
    }
}
