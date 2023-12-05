package faang.school.godbless.twitter_celebrity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class TwitterSubscriptionSystem {

    public static void main(String[] args) {
        List<TwitterAccount> accounts = List.of(
                new TwitterAccount("name 1", new AtomicInteger(0)),
                new TwitterAccount("name 2", new AtomicInteger(0)),
                new TwitterAccount("name 3", new AtomicInteger(0)),
                new TwitterAccount("name 4", new AtomicInteger(0)),
                new TwitterAccount("name 5", new AtomicInteger(0))
                );

        List<CompletableFuture<Void>> futures = new ArrayList<>();

        TwitterAccount account = new TwitterAccount("name 6", new AtomicInteger(0));

        for (int i = 0; i < accounts.size(); i++){
            CompletableFuture<Void> future = followAccount(account);
            futures.add(future);
        }

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allFutures.join();

        System.out.println(account.getUsername() + " has " + account.getFollowers() + " followers");
    }

    public static void addFollower(TwitterAccount twitterAccount){
        twitterAccount.setFollowers();
    }

    public static CompletableFuture<Void> followAccount(TwitterAccount twitterAccount){
        return CompletableFuture.runAsync(() -> {
            addFollower(twitterAccount);
        });
    }
}
