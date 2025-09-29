package school.faang.bjs2_93019;

import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {

        TwitterAccount account1 = new TwitterAccount("Vasya");

        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();

        CompletableFuture<TwitterAccount> addFollower1 = twitterSubscriptionSystem.followAccount(account1);
        CompletableFuture<TwitterAccount> addFollower2 = twitterSubscriptionSystem.followAccount(account1);
        CompletableFuture<TwitterAccount> addFollower3 = twitterSubscriptionSystem.followAccount(account1);
        CompletableFuture<TwitterAccount> addFollower4 = twitterSubscriptionSystem.followAccount(account1);
        CompletableFuture<TwitterAccount> addFollower5 = twitterSubscriptionSystem.followAccount(account1);

        CompletableFuture.allOf(addFollower1, addFollower2, addFollower3, addFollower4, addFollower5)
                .thenRun(() -> System.out.printf("%s now has %d followers. %n",
                        account1.getName(), account1.getFollowers())).join();
    }
}
