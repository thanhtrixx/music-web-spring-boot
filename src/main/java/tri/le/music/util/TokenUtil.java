package tri.le.music.util;

import java.util.UUID;

/**
 * Created by TriLe on 2016-04-02.
 */
public class TokenUtil {

    private static final int TOKEN_SIZE = 36;

    public static String generateToke() {
        return UUID.randomUUID().toString();
    }

    public static boolean validate(String token) {
        if (token != null && token.length() == TOKEN_SIZE)
            return true;

        return false;
    }
}
