package school.faang.bjs250878;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class TwitterSubscriptionSystem {

    private final AtomicInteger totalFollowers = new AtomicInteger(0);

    public synchronized void addFollower(TwitterAccount account) {
        account.addFollower();
        int followersCount = totalFollowers.incrementAndGet();
        log.info("Account {} now has {} followers. Total followers: {}",
                account.getUsername(), account.getFollowers(), followersCount);
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account));
    }

    public void multipleFollowers(TwitterAccount account, int numberOfFollowers) {
        CompletableFuture[] futureFollowers = new CompletableFuture[numberOfFollowers];

        CompletableFuture.allOf(Arrays.stream(futureFollowers)
                .map(f -> followAccount(account))
                .toArray(CompletableFuture[]::new)).join();

        log.info("Final number of followers for account {}: {}", account.getUsername(), account.getFollowers());
    }
}