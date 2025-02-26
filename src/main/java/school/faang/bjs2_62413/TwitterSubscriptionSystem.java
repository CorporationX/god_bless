package school.faang.bjs2_62413;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
public class TwitterSubscriptionSystem {

    public void addFollower(TwitterAccount account) {
        int updatedFollowers = account.incrementFollowers();
        log.info("Follower added to account: {}. Total followers: {}", account.getUserName(), updatedFollowers);
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account));
    }

    public CompletableFuture<Void> followMultipleAccounts(TwitterAccount account, int times) {
        List<CompletableFuture<Void>> futures = IntStream.range(0, times)
                .mapToObj(i -> followAccount(account))
                .toList();

        return CompletableFuture.allOf(
                        futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> log.info("All follow operations completed for account: {}. Final followers count: {}",
                        account.getUserName(), account.getFollowers()));
    }
}
