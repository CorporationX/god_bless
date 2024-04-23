package faang.school.godbless.bjs2_5942;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();

        TwitterAccount vasya = new TwitterAccount("Vasya");

        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            futures.add((twitterSubscriptionSystem.followAccount(vasya)));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenAccept(future -> System.out.println("Count of subscribers for " + vasya.getUsername() + ": " + vasya.getFollowers()));
    }
}
