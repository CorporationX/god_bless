package school.faang.stream4.becometwittercelebrity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Data
@AllArgsConstructor
public class TwitterSubscriptionSystem {
    ExecutorService executorService;

    public void addFollower(TwitterAccount account) {
        synchronized (account) {
            int followers = account.getFollowers();
            account.setFollowers(++followers);
        }
    }

    public CompletableFuture<TwitterAccount> followAccount(TwitterAccount follower, TwitterAccount account) {
        return CompletableFuture.supplyAsync(() -> {
            follower.addSubscription(account);
            addFollower(account);
            return account;
        }, executorService);
    }

}
