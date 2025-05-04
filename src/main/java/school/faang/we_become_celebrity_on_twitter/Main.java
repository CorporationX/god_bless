package school.faang.we_become_celebrity_on_twitter;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();
        TwitterAccount account = new TwitterAccount("testUser", 0);

        CompletableFuture<Void> future1 = system.followAccount(account);
        CompletableFuture<Void> future2 = system.followAccount(account);
        CompletableFuture<Void> future3 = system.followAccount(account);
        CompletableFuture<Void> future4 = system.followAccount(account);
        CompletableFuture<Void> future5 = system.followAccount(account);
        CompletableFuture<Void> future6 = system.followAccount(account);

        CompletableFuture.allOf(future1, future2, future3, future4, future5, future6).join();

        log.info("Final follower count: {}", account.getFollowers());
        system.shutdown();
    }
}
