package school.faang.sprint4.task_50732;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class Main {
    private static final int FOLLOWS_TOTAL = 50000;

    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("Kolega1964");

        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();

        List<CompletableFuture<Void>> futureFollows = IntStream.range(0, FOLLOWS_TOTAL)
                .mapToObj((i) -> subscriptionSystem.followAccount(account))
                .toList();

        CompletableFuture<Void> result = CompletableFuture.allOf(futureFollows.toArray(new CompletableFuture[0]));
        result.join();
        System.out.println("Final followers count: " + account.getFollowersCount());
    }
}
