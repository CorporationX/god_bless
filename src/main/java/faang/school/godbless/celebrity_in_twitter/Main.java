package faang.school.godbless.celebrity_in_twitter;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterAccount acc1 = new TwitterAccount("User1", 12);
        TwitterAccount acc2 = new TwitterAccount("User2", 12736);
        TwitterAccount acc3 = new TwitterAccount("User3", 1398);

        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();

        CompletableFuture<Void> runTwitter1 = twitterSubscriptionSystem.followAccount(acc1, 1400);
        CompletableFuture<Void> runTwitter2 = twitterSubscriptionSystem.followAccount(acc2, 98763);
        CompletableFuture<Void> runTwitter3 = twitterSubscriptionSystem.followAccount(acc3, 123);

        CompletableFuture.allOf(runTwitter1, runTwitter2, runTwitter3).join();
    }
}
