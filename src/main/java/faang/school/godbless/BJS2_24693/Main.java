package faang.school.godbless.BJS2_24693;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {

    private static final int FOLLOWERS_TO_FOLLOW = 10;

    public static void main(String[] args) {

        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();
        TwitterAccount wayne = new TwitterAccount("@wayne");
        TwitterAccount kent = new TwitterAccount("@kent");

        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 0; i < FOLLOWERS_TO_FOLLOW; i++) {
            futures.add(twitterSubscriptionSystem.followAccount(wayne));
            futures.add(twitterSubscriptionSystem.followAccount(kent));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    System.out.println("Followers followed to " + wayne.getName() + ": " + wayne.getFollowersCount());
                    System.out.println("Followers followed to " + kent.getName() + ": " + kent.getFollowersCount());
                })
                .join();
    }
}
