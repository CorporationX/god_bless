package celebrity.twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static final int FOLLOWERS_COUNT = 999;

    public static void main(String[] args) {
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();
        TwitterAccount cemeh666 = new TwitterAccount("cemeh666");
        TwitterAccount durov = new TwitterAccount("durov");
        TwitterAccount putin = new TwitterAccount("putin");

        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 0; i < FOLLOWERS_COUNT; i++) {
            futures.add(twitterSubscriptionSystem.followAccount(cemeh666));
            futures.add(twitterSubscriptionSystem.followAccount(durov));
            if (i % 2 == 0) {
                futures.add(twitterSubscriptionSystem.followAccount(putin));
            }
        }

        CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new))
            .thenRun(() -> {
                System.out.printf(
                    "Количество подписчиков у %s %s\n",
                    cemeh666.getUsername(),
                    cemeh666.getFollowers().get()
                );
                System.out.printf("Количество подписчиков у %s %s\n", durov.getUsername(), durov.getFollowers().get());
                System.out.printf("Количество подписчиков у %s %s\n", putin.getUsername(), putin.getFollowers().get());
            })
            .join();
    }
}
