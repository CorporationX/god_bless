package faang.school.godbless.twitterFollowers;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {
    private synchronized void addFollower(TwitterAccount twitterAccount) {
        twitterAccount.setFollowers(twitterAccount.getFollowers() + 1);
    }

    public CompletableFuture<Void> followAccount(TwitterAccount twitterAccount) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Adding follower failed");
            }
            addFollower(twitterAccount);
            System.out.println("Follower added to: " + twitterAccount.getUsername());
        });
    }
}
