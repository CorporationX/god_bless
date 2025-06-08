package school.faang.util;

import java.util.Date;

public class DatesUtil {
    public static boolean isExpired(long timestamp, long maxAgeMillis) {
        Date time = new Date(timestamp + maxAgeMillis);
        return time.before(new Date());
    }
}
