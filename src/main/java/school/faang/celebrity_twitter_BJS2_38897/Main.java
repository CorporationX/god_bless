package school.faang.celebrity_twitter_BJS2_38897;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("Stepan Ivanov", 240);
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();

        List<CompletableFuture<Void>> futures = new ArrayList<>();
        int countFollowers = 12;
        for (int i = 0; i < countFollowers; i++) {
            futures.add(subscriptionSystem.followAccount(account));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> System.out.println("Followers count: " + account.getFollowers()));
    }
}