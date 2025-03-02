package school.faang.twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class FollowSystem {
    private static final int NEW_FOLLOWERS = 20;

    public static void main(String[] args) {
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();
        TwitterAccount juzu = new TwitterAccount("juzu", 1000);
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 0; i < NEW_FOLLOWERS; i++) {
            futures.add(twitterSubscriptionSystem.followAccount(juzu));
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
    }
}
