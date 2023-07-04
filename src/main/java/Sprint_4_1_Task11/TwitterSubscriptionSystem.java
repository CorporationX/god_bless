package Sprint_4_1_Task11;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {

    public static synchronized void addFollower(TwitterAccount twitterAccount) {
        twitterAccount.setFollowers(twitterAccount.getFollowers() + 1);
    }

    public static CompletableFuture<TwitterAccount> followAccount(TwitterAccount twitterAccount) {
        return CompletableFuture.supplyAsync(() -> {
            TwitterSubscriptionSystem.addFollower(twitterAccount);
            return twitterAccount;
        });
    }

    public static void main(String[] args) {
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();
        TwitterAccount twitterAccount = new TwitterAccount("zazozhik");
        List<CompletableFuture<TwitterAccount>> twitterAccounts = new ArrayList<>();
        for (int i = 0; i < 99999; i++) {
            twitterAccounts.add(TwitterSubscriptionSystem.followAccount(twitterAccount));
        }
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(twitterAccounts.toArray(new CompletableFuture[0]));
        voidCompletableFuture.thenRun(() -> {
            System.out.println(twitterAccount.getFollowers());
        });
        voidCompletableFuture.join();
    }
}
