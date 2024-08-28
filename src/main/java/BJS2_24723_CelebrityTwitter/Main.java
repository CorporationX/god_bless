package BJS2_24723_CelebrityTwitter;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        TwitterAccount twitterAccount = new TwitterAccount("Elon Musk", 50_000_101);
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();

        List<CompletableFuture<Void>> futures = new ArrayList<>(10);

        for (int i = 0; i < 10; i++) {
            futures.add(twitterSubscriptionSystem.followAccount(twitterAccount));
        }

        log.info("Total followers for account {} before subscriptions {}", twitterAccount.getUsername(),
                twitterAccount.getFollowers());

        CompletableFuture<Void> futuresResult = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> log.info("Total followers for account {} is now {}", twitterAccount.getUsername(),
                        twitterAccount.getFollowers()));

        futuresResult.join();
    }
}
