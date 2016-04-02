package tri.le.music.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by thanh on 2016-04-02.
 */
public class SecurityUtil {

    private static final Logger log = LogManager.getLogger(SecurityUtil.class);

    public static String hashPass(String password,String hashAlgorithm) {
        // Check null and empty
        if (StringUtils.isEmpty(password)) {
            throw new IllegalArgumentException("Empty password");
        }

        MessageDigest md;
        try {
            md = MessageDigest.getInstance(hashAlgorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

        md.update(password.getBytes());

        byte byteData[] = md.digest();

        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < byteData.length; i++) {
            hexString.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        String hashPass = hexString.toString();
        log.debug("Value: [{}]; Hash: [{}]", password, hashPass);

        return hashPass;
    }
}