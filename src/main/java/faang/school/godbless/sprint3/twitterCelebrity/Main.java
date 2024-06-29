package faang.school.godbless.sprint3.twitterCelebrity;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem(executorService);

        TwitterAccount account1 = new TwitterAccount("account1", new AtomicInteger(0));

        CompletableFuture<Void> future1 = twitterSubscriptionSystem.followAccount(account1);
        CompletableFuture<Void> future2 = twitterSubscriptionSystem.followAccount(account1);
        CompletableFuture<Void> future3 = twitterSubscriptionSystem.followAccount(account1);
        CompletableFuture<Void> future4 = twitterSubscriptionSystem.followAccount(account1);
        CompletableFuture<Void> future5 = twitterSubscriptionSystem.followAccount(account1);
        CompletableFuture<Void> future6 = twitterSubscriptionSystem.followAccount(account1);

        List<CompletableFuture<Void>> futureList = List.of(future1, future2, future3, future4, future5, future6);

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0]));

        voidCompletableFuture.thenRun(() -> log.info("total amount of followers: {}", account1.getFollowers()));

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(10L, TimeUnit.SECONDS)) {
                log.info("Executor tasks hasn't done. Closing immediately");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("{} is interrupted", Thread.currentThread().getName());
        }

    }
}
