package school.faang.BJS238927;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("Elon Musk", 0);
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            futures.add(subscriptionSystem.followAccount(account));
        }
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> System.out.println("Amount of followers: " + account.getUsername() + " " + account.getFollowers()));
        allFutures.join();
    }
}
