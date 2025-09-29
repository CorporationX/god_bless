package school.faang.multithreading.async.bjs2_92975;

import java.util.concurrent.atomic.AtomicInteger;

public record TwitterAccount(String username, AtomicInteger followers) {
    public TwitterAccount(String username) {
        this(username, new AtomicInteger(0));
    }
}
