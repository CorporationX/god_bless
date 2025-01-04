package school.faang.task_51099;

import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        TwitterSubscriptionSystem ts = new TwitterSubscriptionSystem();
        TwitterAccount account = new TwitterAccount("cr7", 1000);

        CompletableFuture<TwitterAccount> follower1 = ts.followAccount(account);
        CompletableFuture<TwitterAccount> follower2 = ts.followAccount(account);
        CompletableFuture<TwitterAccount> follower3 = ts.followAccount(account);
        CompletableFuture<TwitterAccount> follower4 = ts.followAccount(account);

        CompletableFuture.allOf(follower1, follower2, follower3, follower4).join();
        System.out.println("На аккаунт подписались " + account.getFollowers());
    }
}
