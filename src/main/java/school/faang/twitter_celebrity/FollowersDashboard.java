package school.faang.twitter_celebrity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class FollowersDashboard {

    public static void main(String[] args) {
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();
        List<TwitterAccount> accounts = List.of(
                new TwitterAccount("Sarah", 0),
                new TwitterAccount("Bob", 2),
                new TwitterAccount("Elon", 1)
        );

        List<CompletableFuture<Void>> futures = accounts.stream()
                .map(system::followAccount)
                .toList();

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allFutures.join();
    }
}
