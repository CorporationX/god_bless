package faang.school.godbless.becomingACelebrityOnTwitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static final int NUM_FOLLOW_ACCOUNT = 12;

    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("1", 0);
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 1; i <= NUM_FOLLOW_ACCOUNT; i++) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                subscriptionSystem.followAccount(account);
            });
            futures.add(future);
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        System.out.println(account.getFollowers());
    }
}
