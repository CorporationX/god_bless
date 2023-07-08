package faang.school.godbless.sprint4.twitter;


import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterAccount twitterAccount = new TwitterAccount("Pavel", 1);

        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();
        CompletableFuture<Void> future = null;

        for (int i = 0; i < 5; ++i) {
            future = twitterSubscriptionSystem.followAccount(twitterAccount);
        }

        CompletableFuture.allOf(future).join();

        System.out.println(twitterAccount.getFollowers());
    }
}
