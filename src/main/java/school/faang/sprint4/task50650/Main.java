package school.faang.sprint4.task50650;

import lombok.extern.slf4j.Slf4j;
import school.faang.sprint4.task50650.model.TwitterAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_OF_FOLLOWERS = 10;
    private static final int THREADS_NUM = 10;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREADS_NUM);
        TwitterAccount account = new TwitterAccount("Elon Mask");
        List<CompletableFuture<Void>> results = new ArrayList<>();

        for (int i = 0; i < NUM_OF_FOLLOWERS; i++) {
            results.add(TwitterSubscriptionSystem.followAccount(executor, account));
        }

        CompletableFuture.allOf(results.toArray(new CompletableFuture[results.size()])).join();

        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
        log.info("У аккаунта {} зарегистрировано {} подписчиков", account.getUsername(), account.getFollowers().get());
    }
}
