package faang.school.godbless.BJS2_6138;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterAccount twitterAccount1 = new TwitterAccount("John", 0);
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();

        CompletableFuture.allOf(
                twitterSubscriptionSystem.followAccount(twitterAccount1),
                twitterSubscriptionSystem.followAccount(twitterAccount1),
                twitterSubscriptionSystem.followAccount(twitterAccount1),
                twitterSubscriptionSystem.followAccount(twitterAccount1),
                twitterSubscriptionSystem.followAccount(twitterAccount1),
                twitterSubscriptionSystem.followAccount(twitterAccount1),
                twitterSubscriptionSystem.followAccount(twitterAccount1)).join();

        System.out.println(twitterAccount1.getFollowers());
    }

}
