package twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("Olya", 23);
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();
        List<CompletableFuture<Void>> tasks = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            tasks.add(twitterSubscriptionSystem.followAccount(account));
        }
        CompletableFuture<Void> allTask = CompletableFuture.allOf(tasks.toArray(new CompletableFuture[0]));
        allTask.thenRun(() -> System.out.println("Final follower count for " + account.getUserName() + " : " + account.getFollowers()));
        allTask.join();
    }
}
