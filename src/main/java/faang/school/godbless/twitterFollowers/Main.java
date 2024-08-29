package faang.school.godbless.twitterFollowers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();

        TwitterAccount account = new TwitterAccount("Elon Musk");

        List<CompletableFuture<Void>> futures = new ArrayList<>();

        futures.add(subscriptionSystem.followAccount(account));
        futures.add(subscriptionSystem.followAccount(account));
        futures.add(subscriptionSystem.followAccount(account));
        futures.add(subscriptionSystem.followAccount(account));
        futures.add(subscriptionSystem.followAccount(account));

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        try {
            allOf.get();
            System.out.println("Now Elon Musk has " + account.getFollowers() + " followers");
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Interrupted");
        }
    }
}
