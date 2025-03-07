package school.faang.module1.sprint4.twittercelebrity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        List<CompletableFuture<Void>> tasks = new ArrayList<>();
        TwitterAccount twitterAccount = new TwitterAccount("Hazza");
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();

        for (int i = 0; i < 10; i++) {
            CompletableFuture<Void> future = twitterSubscriptionSystem.followAccount(twitterAccount);
            tasks.add(future);
        }

        CompletableFuture.allOf(tasks.toArray(new CompletableFuture[0])).join();

        twitterSubscriptionSystem.shutdownExecutors();
    }
}