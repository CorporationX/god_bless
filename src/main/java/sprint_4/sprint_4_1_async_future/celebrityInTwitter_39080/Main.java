package sprint_4.sprint_4_1_async_future.celebrityInTwitter_39080;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    private static final int COUNT_FOLLOWERS = 1_000_000;

    public static void main(String[] args) {
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();
        TwitterAccount account = new TwitterAccount("Celebrity");

        List<CompletableFuture<Void>> futures = new ArrayList<>(COUNT_FOLLOWERS);
        for (int i = 0; i < COUNT_FOLLOWERS; i++) {
            futures.add(subscriptionSystem.followAccount(account));
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        log.info("Followers {}: {}", account.getUsername(), account.getFollowers());
    }
}
