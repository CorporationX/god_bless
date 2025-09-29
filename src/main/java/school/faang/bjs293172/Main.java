package school.faang.bjs293172;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();
        TwitterAccount account1 = new TwitterAccount("account1", 100);

        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> subscriptionSystem.followAccount(account1));
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> subscriptionSystem.followAccount(account1));
        CompletableFuture<Void> future3 = CompletableFuture.runAsync(() -> subscriptionSystem.followAccount(account1));

        CompletableFuture.allOf(future1, future2, future3).join();

        System.out.println("Final number of followers for " + account1.getUsername() + ": " + account1.getFollowers());
    }
}
