package school.faang.twittercelebrity;

import java.util.concurrent.atomic.AtomicInteger;

public record TwitterAccount(String username, AtomicInteger followers) {
    public TwitterAccount(String username) {
        this(username, new AtomicInteger(0));
    }
}
