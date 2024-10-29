package twitterfollowers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static final int INITIAL_NUMBER_OF_SUBSCRIBERS = 3;
    private static final int NUMBER_OF_NEW_SUBSCRIBERS = 5;

    public static void main(String[] args) {
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();
        TwitterAccount twitterAccount = new TwitterAccount("user1",
                new AtomicInteger(INITIAL_NUMBER_OF_SUBSCRIBERS));

        List<CompletableFuture<Void>> followFutures = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_NEW_SUBSCRIBERS; i++) {
            followFutures.add(subscriptionSystem.followAccount(twitterAccount));
        }

        CompletableFuture.allOf(followFutures.toArray(new CompletableFuture[0])).join();
        System.out.printf("имя пользователя: %s, количество подписчиков: %s \n",
                twitterAccount.getUsername(), twitterAccount.getFollowers());
    }
}
