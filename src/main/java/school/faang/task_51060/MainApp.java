package school.faang.task_51060;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class MainApp {
    public static void main(String[] args) {
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();

        TwitterAccount account = new TwitterAccount("TestAccount");
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        List<CompletableFuture<Void>> tasks = new ArrayList<>();

        IntStream.range(0, 100).forEach(i ->
                tasks.add(CompletableFuture.runAsync(() -> subscriptionSystem.followAccount(account), executorService))
        );
        CompletableFuture.allOf(tasks.toArray(new CompletableFuture[0])).join();
        executorService.shutdown();

        System.out.println("All followers: " + account.getFollowersCount().get());
    }
}
