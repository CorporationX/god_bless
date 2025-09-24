package school.faang.bjs2_92958;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int SIZE_POOL_THREAD = 10;
    private static final int RANDOM_SUBSTRING = 1000;
    private static List<CompletableFuture<Void>> futures = new ArrayList<>();
    private static TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();

    public static void main(String[] args) {
        TwitterAccount twitterAccount = new TwitterAccount("Twit", new AtomicInteger(0));

        ExecutorService executorService = Executors.newFixedThreadPool(SIZE_POOL_THREAD);

        int r = new Random().nextInt(RANDOM_SUBSTRING);
        log.info("Доступная накрутка подписчиков на аккаунт {} - {}", twitterAccount.getUsername(), r);

        futures = IntStream.rangeClosed(1, r)
                .mapToObj(i -> {
                    CompletableFuture<Void> future = CompletableFuture.runAsync(
                            () -> system.followAccount(twitterAccount),
                            executorService);
                    return future;
                })
                .collect(Collectors.toList());

        executorService.shutdown();
        CompletableFuture<Void> allFollowFutures = CompletableFuture.allOf(
                futures.toArray(new CompletableFuture[0]));

        allFollowFutures.thenRun(() -> log.info("Результат - {}", twitterAccount));
    }
}
