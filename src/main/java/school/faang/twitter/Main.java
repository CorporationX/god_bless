package school.faang.twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static final int COUNT_FOLLOWERS = 1_000_000;
    public static void main(String[] args) {
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();
        TwitterAccount twitterAccount = new TwitterAccount("Star", 0);

        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < COUNT_FOLLOWERS; i++) {
            futures.add(twitterSubscriptionSystem.followAccount(twitterAccount));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        System.out.println("Количество подписчиков: " + twitterAccount.getFollowers());
    }
}