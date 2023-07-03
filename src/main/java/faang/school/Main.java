package faang.school;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem processor = new TwitterSubscriptionSystem();
        TwitterAccount account = new TwitterAccount("mama");
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 10000; i++) {
            if (i % 2 == 0) {
                CompletableFuture.runAsync(() -> processor.followAccount(account), executor);
            } else {
                futures.add(CompletableFuture.runAsync(() -> processor.addFollowers(account), executor));
            }
        }
        CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new)).thenRun(() -> {
            executor.shutdown();
            try {
                executor.awaitTermination(4, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(account.getFollowers());
        }).join();
    }
}
