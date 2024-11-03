package school.faang.stprint4.twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {
    private List<CompletableFuture<TwitterAccount>> futures = new ArrayList<>();

    private synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers()+1);
    }

    public void followAccount(TwitterAccount account) {
        futures.add(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Invalid async");
            }
            addFollower(account);
            return account;
        }));
    }

    public void getTotalSubscribers(TwitterAccount account) {
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> System.out.println("\nAccount " + account.getName() + " has total " +  account.getFollowers() + " followers"));
    }
}
