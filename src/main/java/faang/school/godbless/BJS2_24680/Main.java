package faang.school.godbless.BJS2_24680;

import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("Robert");

        var futures = IntStream.range(0, 100_000)
                .mapToObj(i -> TwitterSubscriptionSystem.followAccount(account))
                .toList();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        System.out.println("Result: " + account.getFollowersCount().get());
    }
}
