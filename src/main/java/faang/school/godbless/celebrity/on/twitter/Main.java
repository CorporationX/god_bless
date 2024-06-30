package faang.school.godbless.celebrity.on.twitter;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("user1", 0L);
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();

        CompletableFuture<Void> future1 = system.followAccount(account);
        CompletableFuture<Void> future2 = system.followAccount(account);
        CompletableFuture<Void> future3 = system.followAccount(account);

        CompletableFuture.allOf(future1, future2, future3).join();

        System.out.println("Total followers: " + account.getFollowers());
    }
}
