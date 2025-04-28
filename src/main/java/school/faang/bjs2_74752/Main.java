package school.faang.bjs2_74752;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.SECONDS;

@Slf4j
public class Main {
    private static final int MAX_EXPECTATION = 60;
    private static final int NUM_THREADS = 10;

    public static void main(String[] args) {
        List<TwitterAccount> twitterAccountList = List.of(
                new TwitterAccount("Twitter", 100),
                new TwitterAccount("Elon Musk", 203),
                new TwitterAccount("Cristiano Ronaldo", 10200));
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();


        ExecutorService pool = Executors.newFixedThreadPool(NUM_THREADS);

        CompletableFuture<Void> everyoneSignedUp = CompletableFuture.allOf(
                twitterAccountList.stream()
                        .map(account -> CompletableFuture.runAsync(() -> system.followAccount(account, pool))
                                .thenRun(() -> log.info("Everyone signed up for an account {}", account.getUsername())))
                        .toArray(CompletableFuture[]::new));

        everyoneSignedUp.join();

        log.info("All tasks completed");
        gracefullyShutdown(pool);
    }


    private static void gracefullyShutdown(ExecutorService pool) {
        pool.shutdown();
        try {
            boolean isClose = pool.awaitTermination(MAX_EXPECTATION, SECONDS);
            if (!isClose) {
                pool.shutdownNow();
            }
        } catch (InterruptedException ex) {
            log.error("Thread stoppage error");
            pool.shutdownNow();
        }
    }
}
