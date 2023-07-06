package faang.school.godbless.TwitterCelebrity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Application {
    private static TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();

    public static void main(String[] args) {

        TwitterAccount twitterAccount = new TwitterAccount("Ilon Mask", 59);
        List<CompletableFuture> futures = new ArrayList<>();

        for (int i = 0; i < 13; i++) {
            futures.add(followAccount(twitterAccount));
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()])).join();

        System.out.println(twitterAccount.getFollowers());

    }

    public static CompletableFuture followAccount(TwitterAccount twitterAccount) {
        var futureSubscription = CompletableFuture.supplyAsync(() -> {
            twitterSubscriptionSystem.addFollower(twitterAccount);
            return twitterAccount.getFollowers();
        });
        return futureSubscription;
    }
}
