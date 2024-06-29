package faang.school.godbless.twitter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class TwitterSubscriptionSystem {
    private Object lockOne = new Object();
    private void addFollower(TwitterAccount account) {
        synchronized (lockOne) {
            Integer followers = account.getFollowers();
            account.setFollowers(followers+1);
        }
    }
    public void followAccount(TwitterAccount account) throws InterruptedException, ExecutionException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(()->{
            try {
                Thread.sleep(500);
                addFollower(account);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        future.thenRun(()->{
            System.out.println("subscription completed");
            System.out.println(account.getFollowers());
        });
        future.get();
    }
}
