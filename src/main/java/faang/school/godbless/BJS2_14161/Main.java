package faang.school.godbless.BJS2_14161;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();
        TwitterAccount account = new TwitterAccount("Test", 0);

        List<CompletableFuture<Void>> accounts = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            accounts.add(twitterSubscriptionSystem.followAccount(account));
        }

        CompletableFuture<Void> followFuture = CompletableFuture.allOf(accounts.toArray(new CompletableFuture[0]));
        followFuture.join();
        TwitterSubscriptionSystem.EXECUTOR.shutdown();
        System.out.println(account);
    }
}
