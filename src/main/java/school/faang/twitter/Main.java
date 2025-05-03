package school.faang.twitter;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();
        TwitterAccount account1 = new TwitterAccount("Bob");
        TwitterAccount account2 = new TwitterAccount("Vlad");

        List<CompletableFuture<Void>> completableFutures = List.of(
                twitterSubscriptionSystem.followAccount(account1),
                twitterSubscriptionSystem.followAccount(account1),
                twitterSubscriptionSystem.followAccount(account1),
                twitterSubscriptionSystem.followAccount(account2));
        completableFutures.forEach(CompletableFuture::join);

        log.info("followers for account {} - {}", account1, account1.getFollowers());
        log.info("followers for account {} - {}", account2, account2.getFollowers());
        ThreadPullProvider.gracefullyShutDown();
    }
}
