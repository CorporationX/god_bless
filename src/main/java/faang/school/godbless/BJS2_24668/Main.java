package faang.school.godbless.BJS2_24668;

import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class Main {
    private static final int FUTURE_FOLLOWERS = 50;
    public static void main(String[] args) {
        TwitterAccount mask = new TwitterAccount("Elon");
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();

        CompletableFuture<Void> futures = CompletableFuture.allOf(IntStream
                .range(0, FUTURE_FOLLOWERS)
                .mapToObj(x -> twitterSubscriptionSystem.followAccount(mask))
                .toArray(CompletableFuture[]::new));

        futures.join();
        twitterSubscriptionSystem.shutdown();
        System.out.println(mask.getFollowers());
    }
}
