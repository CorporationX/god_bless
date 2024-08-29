package faang.school.godbless.BeingACelebrity;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionsSystem {
    public synchronized void addFollower(TwitterAccount twitterAccount) {
        twitterAccount.setFollowers(twitterAccount.getFollowers() + 1);
    }

    public CompletableFuture<Void> followAccount(TwitterAccount twitterAccount) {
        return CompletableFuture.runAsync(() -> addFollower(twitterAccount));
    }

    public static void main(String[] args) {
        TwitterSubscriptionsSystem subscriptionsSystem = new TwitterSubscriptionsSystem();
        TwitterAccount account1 = new TwitterAccount("johnDoe", 100);
        TwitterAccount account2 = new TwitterAccount("janeDoe", 500);
        TwitterAccount account3 = new TwitterAccount("celebrity", 10000);
        List<CompletableFuture<Void>> allAccounts = List.of(
                subscriptionsSystem.followAccount(account3),
                subscriptionsSystem.followAccount(account1),
                subscriptionsSystem.followAccount(account2));

        CompletableFuture.allOf(allAccounts.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    System.out.println("Account 1 followers: " + account1.getFollowers());
                    System.out.println("Account 2 followers: " + account2.getFollowers());
                    System.out.println("Account 3 followers: " + account3.getFollowers());
                });
    }
}