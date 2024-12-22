package school.faang.task_50656;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    private static final int POOL_SIZE = 5;
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger();
        TwitterAccount twitterAccount = new TwitterAccount("az3l1t", atomicInteger);

        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();
        ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE);

        List<CompletableFuture<Integer>> tasks = IntStream.range(0, POOL_SIZE)
                .mapToObj(i -> twitterSubscriptionSystem.followAccount(twitterAccount))
                .toList();

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(
                tasks.toArray(new CompletableFuture[5])
        );

        allTasks.whenComplete((result, exception) -> {
            if (exception != null) {
                System.out.println("Something went wrong : 26, Main");
            } else {
                tasks.forEach(task -> {
                    try {
                        System.out.println(task.get());
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        });

        allTasks.join();
        if (!executorService.awaitTermination(15, TimeUnit.SECONDS)) {
            executorService.shutdown();
        }
    }
}