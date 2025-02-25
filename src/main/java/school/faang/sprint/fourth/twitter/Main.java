package school.faang.sprint.fourth.twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();

        List<CompletableFuture<Void>> completableFutures = new ArrayList<>();
        TwitterAccount vovaAccount = new TwitterAccount("Vova");
        TwitterAccount petyaAccount = new TwitterAccount("Petya");

        for (int i = 0; i <= 10; i++) {
            completableFutures.add(twitterSubscriptionSystem.followAccount(vovaAccount));
            completableFutures.add(twitterSubscriptionSystem.followAccount(petyaAccount));
        }

        CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0])).join();
        twitterSubscriptionSystem.shutdown();

    }
}
