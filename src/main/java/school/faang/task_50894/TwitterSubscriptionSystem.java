package school.faang.task_50894;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {

    public synchronized void addFollower(TwitterAccount account, TwitterAccount subscriber) {
        if (account.equals(subscriber)) {
            System.out.println("Вы не можете подписаться сами на себя");
            return;
        }
        account.setFollowers(account.getFollowers() + 1);
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account, TwitterAccount subscriber) {
        System.out.println("На вас подписался " + subscriber.getUsername());
        return CompletableFuture.runAsync(() -> this.addFollower(account, subscriber));
    }
}
