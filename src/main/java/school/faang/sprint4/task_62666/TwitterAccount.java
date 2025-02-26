package school.faang.sprint4.task_62666;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RequiredArgsConstructor
@Getter
@ToString
public class TwitterAccount {
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(5);

    private final String userName;
    private final AtomicInteger followers = new AtomicInteger();

    public void addFollower(TwitterAccount account) {
        int count = followers.incrementAndGet();
        log.debug("Account {} add new follower {}, now has {} followers", userName, account.userName, count);
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> account.addFollower(this), EXECUTOR);
    }

    public void closeExecutor() {
        EXECUTOR.shutdownNow();
    }

    public int getFollowers() {
        return followers.get();
    }
}
