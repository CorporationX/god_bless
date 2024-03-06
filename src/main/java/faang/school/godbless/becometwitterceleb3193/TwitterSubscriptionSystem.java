package faang.school.godbless.becometwitterceleb3193;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class TwitterSubscriptionSystem {

    private synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
        if (account.getName().equals("FAANG SCHOOL")) {
            System.out.println("You subscribed to the best Twitter account");
        }
    }

    public CompletableFuture<TwitterAccount> followAccount(TwitterAccount account, ExecutorService executor) {
        return CompletableFuture.supplyAsync(() -> {
            addFollower(account);
            return account;
        }, executor);
    }
}
