package twitterfollowers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();
        TwitterAccount account1 = new TwitterAccount("user1", 3);

        List<CompletableFuture<Void>> followFutures = new ArrayList<>();
        followFutures.add(subscriptionSystem.followAccount(account1));
        followFutures.add(subscriptionSystem.followAccount(account1));
        followFutures.add(subscriptionSystem.followAccount(account1));

        CompletableFuture.allOf(followFutures.toArray(new CompletableFuture[0])).join();
        System.out.printf("имя пользователя: %s, количество подписчиков: %d",
                account1.getUsername(), account1.getFollowers());
    }
}
