package faang.school.godbless.module.fourth.async.twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TwitterSubscriptionSystem {
    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("Lady Gaga");
        
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            futures.add(followAccount(account));
        }
        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allOf.join();
        allOf.thenRun(() -> log.info("Account {} has {} followers", account.getUsername(), account.getFollowers()));
    }
    
    public static void addFollower(TwitterAccount account) {
        synchronized (account) {
            account.addFolower();
        }
    }
    
    public static CompletableFuture<Void> followAccount(TwitterAccount account) {
        log.info("New follower for account {}", account.getUsername());
        return CompletableFuture.runAsync(() -> addFollower(account));
    }
}
