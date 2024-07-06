package faang.school.godbless.celebrity.on.twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("user1", 0L);
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();

        List<CompletableFuture<Void>> futureList = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            futureList.add(system.followAccount(account));
        }

        CompletableFuture allFutures = CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0]));
        allFutures.thenRun(() -> {
            System.out.println("All followers added.");
            System.out.println("Total followers for account @" + account.getUsername() + ": " + account.getFollowers());
        }).join();

        System.out.println("Total followers: " + account.getFollowers());
    }
}
