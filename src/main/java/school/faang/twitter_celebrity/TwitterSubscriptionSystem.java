package school.faang.twitter_celebrity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {

    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("Bread Pitt");
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        int followersToAddCount = 150;
        for (int i = 1; i <= followersToAddCount; i++) {
            futures.add(followAccount(account));
        }

        while (!CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).isDone()) {
            System.out.println("following...");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(account.getFollowers() + " - количество подписчиков");
    }

    public static synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
    }

    public static CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account));
    }
}

