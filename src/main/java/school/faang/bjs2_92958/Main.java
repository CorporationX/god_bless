package school.faang.bjs2_92958;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int SIZE_POOL_THREAD = 10;
    private static final int RANDOM_SUBSTRING = 1000;

    public static void main(String[] args) {
        TwitterAccount twitterAccount = new TwitterAccount("Twit", 0);

        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();
        ExecutorService executorService = Executors.newFixedThreadPool(SIZE_POOL_THREAD);
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        int r = new Random().nextInt(RANDOM_SUBSTRING);
        log.info("Доступная накрутка подписчиков на аккаунт {} - {}", twitterAccount.getUsername(), r);
        IntStream.rangeClosed(1, r).forEach((i) -> {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> system.followAccount(twitterAccount),
                    executorService);
            futures.add(future);
        });
        executorService.shutdown();
        CompletableFuture<Void> allFollowFutures = CompletableFuture.allOf(
                futures.toArray(new CompletableFuture[0]));

        allFollowFutures.thenRun(() -> log.info("Результат - {}", twitterAccount));
    }
}
