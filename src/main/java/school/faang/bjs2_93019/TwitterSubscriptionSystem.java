package school.faang.bjs2_93019;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {

    public synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
    }

    public CompletableFuture<TwitterAccount> followAccount(TwitterAccount account) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.printf("%s is adding a follower to account %s%n",
                        Thread.currentThread().getName(), account.getName());
                Thread.sleep(2000);
                addFollower(account);
                System.out.printf("%s added a follower added to account %s%n",
                        Thread.currentThread().getName(), account.getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return account;
        });
    }
}
