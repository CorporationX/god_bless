package school.faang.celebruty.twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int NUM_OF_TASKS = 10000;

    public static void main(String[] args) {
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();
        TwitterAccount account = new TwitterAccount("kokin");

        ExecutorService executor = Executors.newFixedThreadPool(8);
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < NUM_OF_TASKS; i++) {
            futures.add(CompletableFuture.runAsync(() ->
                    twitterSubscriptionSystem.followAccount(account), executor));
        }
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allTasks.thenRun(() -> System.out.println("Кол-во подписчиков у " + account.getUsername()
                        + " " + account.getFollowersCount()))
                .whenComplete((res, ex) -> executor.shutdown());
        allTasks.join();
        twitterSubscriptionSystem.shutdown();
    }
}
