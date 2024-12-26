package school.faang.task_50721;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem(Constants.NUM_THREADS.getValue());
        TwitterAccount account = new TwitterAccount("stevangulov");

        CompletableFuture<Void> allFollows = CompletableFuture.allOf(
                subscriptionSystem.followAccount(account),
                subscriptionSystem.followAccount(account),
                subscriptionSystem.followAccount(account)
        );

        allFollows.join();

        log.info("{} has the number of subscribers: {}", account.getUsername(), account.getFollowers());

        subscriptionSystem.shutdown();
    }
}