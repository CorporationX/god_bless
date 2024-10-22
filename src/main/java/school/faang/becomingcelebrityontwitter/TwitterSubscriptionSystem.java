package school.faang.becomingcelebrityontwitter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TwitterSubscriptionSystem {
    private final Lock lock = new ReentrantLock();
}
