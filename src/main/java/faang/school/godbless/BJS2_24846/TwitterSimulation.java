package faang.school.godbless.BJS2_24846;

import java.util.concurrent.CompletableFuture;

public class TwitterSimulation {
    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("Artem");
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();

        CompletableFuture<Void> future1 = subscriptionSystem.followAccount(account);
        CompletableFuture<Void> future2 = subscriptionSystem.followAccount(account);
        CompletableFuture<Void> future3 = subscriptionSystem.followAccount(account);

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2, future3);
        allFutures.join();

        System.out.println(account.getUsername() + ", всего подписчиков: " + account.getFollowers());
    }
}
