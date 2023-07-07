package faang.school.godbless.twitter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwitterSubscriptionSystem {
    public void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);

        System.out.println("added new subscriber");
    }

    public synchronized CompletableFuture<TwitterAccount> followAccount(TwitterAccount account) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            addFollower(account);

            return account;
        }, executorService);
    }
}
