package school.faang.celebritytwitbjs50953;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("example_user");
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();

        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            futures.add(subscriptionSystem.followAccount(account));
        }

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new
                CompletableFuture[0]));
        allOf.join();

        System.out.println("Total followers: " + account.getFollowers());
    }
}
