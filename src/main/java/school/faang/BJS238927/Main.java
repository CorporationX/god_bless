package school.faang.BJS238927;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("Elon Musk", 0);
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();

        CompletableFuture<Void> future1 = subscriptionSystem.followAccount(account);
        CompletableFuture<Void> future2 = subscriptionSystem.followAccount(account);
        CompletableFuture<Void> future3 = subscriptionSystem.followAccount(account);
        CompletableFuture<Void> future4 = subscriptionSystem.followAccount(account);
        CompletableFuture<Void> future5 = subscriptionSystem.followAccount(account);

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2, future3, future4, future5)
                .thenRun(() -> System.out.println("Amount of followers: " + account.getUsername() + " " + account.getFollowers()));
        allFutures.join();
    }
}
