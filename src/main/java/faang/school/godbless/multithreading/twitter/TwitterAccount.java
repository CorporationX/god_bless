package faang.school.godbless.multithreading.twitter;

import java.util.concurrent.atomic.AtomicInteger;

public record TwitterAccount(String username, AtomicInteger followers) {
    public void incrementFollowers() {
        followers.incrementAndGet();
    }
}
