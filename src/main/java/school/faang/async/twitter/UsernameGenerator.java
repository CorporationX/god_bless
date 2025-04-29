package school.faang.async.twitter;

import java.util.concurrent.atomic.AtomicInteger;

public class UsernameGenerator {

    private static final AtomicInteger id = new AtomicInteger(0);

    public static String generateUserName() {
        return String.format("Username %d", id.getAndAdd(1));
    }
}
