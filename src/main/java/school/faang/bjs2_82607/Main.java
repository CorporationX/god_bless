package school.faang.bjs2_82607;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("user123", 0);

        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();

        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CompletableFuture<Void> future = system.followAccount(account);
            futures.add(future);
        }

        CompletableFuture<Void> all = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        all.join();

        System.out.println("Followers count: " + account.getFollowers());
    }
}
