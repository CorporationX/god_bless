package school.faang.celebritytwitbjs50953;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("example_user");
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();

        List<CompletableFuture<Void>> futures = IntStream.range(0, 10)
                .mapToObj(i -> subscriptionSystem.followAccount(account))
                .collect(Collectors.toList());

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new
                CompletableFuture[0]));
        allOf.join();

        System.out.println("Total followers: " + account.getFollowers());
    }
}
