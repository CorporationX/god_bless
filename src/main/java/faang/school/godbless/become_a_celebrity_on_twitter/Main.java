package faang.school.godbless.become_a_celebrity_on_twitter;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();
        CompletableFuture<Void>[] futures = new CompletableFuture[100];
        TwitterAccount account = new TwitterAccount("Rap");

        for (int i = 0; i < futures.length; i++) {
            CompletableFuture<Void> future = subscriptionSystem.followAccount(account);
            futures[i] = future;
        }

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures);
        allFutures.join();

        System.out.println(account.getFollowers());
    }
}
