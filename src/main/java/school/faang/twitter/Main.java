package school.faang.twitter;

import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        TwitterAccount twitterAccount = new TwitterAccount("@exmpl", 0);
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();

        CompletableFuture<?>[] futures = IntStream.range(1, 100)
                .mapToObj(i -> subscriptionSystem.followAccount(twitterAccount))
                .toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(futures).join();

        System.out.printf("Total subscribers: %d", twitterAccount.getFollowers());
    }
}
