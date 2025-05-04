package bjs2_74779;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
public class TwitterSubscriptionSystem {
    private static final int WORKING_TIME = 5;

    public void addFollower(TwitterAccount account) {
        account.getFollowers().incrementAndGet();
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(WORKING_TIME);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            addFollower(account);
            log.info("A new subscriber has been added to the account \"{}\"", account.getUsername());
        });
    }

    public static void main(String[] args) {
        TwitterSubscriptionSystem ts = new TwitterSubscriptionSystem();

        TwitterAccount account1 = new TwitterAccount("John Bullett", 2);

        List<CompletableFuture<Void>> futures = List.of(ts.followAccount(account1), ts.followAccount(account1), ts.followAccount(account1));

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allOf.join();

        log.info("{} has {} subscribers", account1.getUsername(), account1.getFollowers().get());
    }
}
