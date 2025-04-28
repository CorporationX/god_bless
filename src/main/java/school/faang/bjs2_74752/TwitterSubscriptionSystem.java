package school.faang.bjs2_74752;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.stream.IntStream;

@Slf4j
public final class TwitterSubscriptionSystem {

    public CompletableFuture<Void> followAccount(TwitterAccount account, ExecutorService pool) {
        return CompletableFuture.allOf(
                IntStream.range(0, 10)
                        .mapToObj(i -> CompletableFuture.runAsync(() -> addFollower(account), pool)
                                .thenRun(() -> log.info("Number {} subscribed to the {} account.",
                                        i, account.getUsername())))
                        .toArray(CompletableFuture[]::new));
    }

    private void addFollower(TwitterAccount account) {
        account.getFollowers().incrementAndGet();
    }
}
