package tri.le.music.util;

import java.security.SecureRandom;

/**
 * Created by thanh on 2016-04-02.
 */
public class TokenUtil {

    public static String generateToke() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        String token = bytes.toString();
        return token;
    }
}
