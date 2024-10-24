package school.faang.fourthStream.BJS2_38997;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static final int FOLLOWERS_COUNT = 10;

    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("Elon Musk");
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();

        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 0; i < FOLLOWERS_COUNT; i++) {
            CompletableFuture<Void> future = subscriptionSystem.followAccount(account);
            futures.add(future);
        }

        subscriptionSystem.waitForCompletionAndPrint(account, futures.toArray(new CompletableFuture[0]));
    }
}
