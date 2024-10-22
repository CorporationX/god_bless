package school.faang.celebrity_twitter.main;

import school.faang.celebrity_twitter.main_code.TwitterAccount;
import school.faang.celebrity_twitter.main_code.TwitterSubscriptionSystem;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("some name", 0);

        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();

        CompletableFuture<Void> future1 = subscriptionSystem.followAccount(account);
        CompletableFuture<Void> future2 = subscriptionSystem.followAccount(account);
        CompletableFuture<Void> future3 = subscriptionSystem.followAccount(account);
        CompletableFuture<Void> future4 = subscriptionSystem.followAccount(account);
        CompletableFuture<Void> future5 = subscriptionSystem.followAccount(account);

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2, future3, future4, future5);

        allFutures.thenRun(() -> System.out.println("количество подписчиков у " + account.getUsername() +
                " " + account.getFolowers()));

        allFutures.join();
    }
}
