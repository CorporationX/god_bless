package bjs2_37883;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class TwitterSubscriptionSystem {

    public synchronized void addFollower(TwitterAccount twitterAccount) {
        twitterAccount.setFollowers(twitterAccount.getFollowers() + 1);
    }

    public void followAccountAll(TwitterAccount twitterAccount, int followers) {
        List<CompletableFuture<Void>> followedAccounts = IntStream.range(0, followers)
                .boxed()
                .map((num) -> followAccount(twitterAccount))
                .toList();

        CompletableFuture.allOf(followedAccounts.toArray(new CompletableFuture[0])).join();
    }

    private CompletableFuture<Void> followAccount(TwitterAccount twitterAccount) {
        return CompletableFuture.runAsync(() -> addFollower(twitterAccount));
    }
}
