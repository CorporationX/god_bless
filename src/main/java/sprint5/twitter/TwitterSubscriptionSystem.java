package sprint5.twitter;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {
    public CompletableFuture<Void> followAccount(TwitterAccount subscribes, TwitterAccount subscribedTo) {
        return CompletableFuture.runAsync(() -> addFollower(subscribes, subscribedTo));
    }

    private synchronized void addFollower(TwitterAccount subscribes, TwitterAccount subscribedTo) {
        System.out.printf("%s subscribed to Elon Musk\n", subscribes.getName());
        subscribedTo.incrementFollowers();
    }
}
