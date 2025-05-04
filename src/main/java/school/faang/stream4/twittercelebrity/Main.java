package school.faang.stream4.twittercelebrity;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static final int NUMBER_OF_USERS = 5;

    public static void main(String[] args) {
        ConcurrentHashMap<Integer, TwitterAccount> accountHashMap = new ConcurrentHashMap<>();

        for (int i = 1; i <= NUMBER_OF_USERS; i++) {
            accountHashMap.put(i, new TwitterAccount(String.format("User %d", i)));
        }

        ExecutorService pool = Executors.newCachedThreadPool();

        CompletableFuture<Void> future1 =
                CompletableFuture.runAsync(() -> accountHashMap.get(1).followAccount(accountHashMap.get(3)).join(), pool);
        CompletableFuture<Void> future2 =
                CompletableFuture.runAsync(() -> accountHashMap.get(2).followAccount(accountHashMap.get(3)).join(), pool);
        CompletableFuture<Void> future3 =
                CompletableFuture.runAsync(() -> accountHashMap.get(4).followAccount(accountHashMap.get(3)).join(), pool);
        CompletableFuture<Void> future4 =
                CompletableFuture.runAsync(() -> accountHashMap.get(5).followAccount(accountHashMap.get(3)).join(), pool);

        CompletableFuture.allOf(future1, future2, future3, future4)
                .thenRun(() -> System.out.printf("У юзера с id 3 количество подписчиков = %d%n",
                        accountHashMap.get(3).getFollowers()))
                .join();

        pool.shutdown();

        try {
            if (!pool.awaitTermination(5, TimeUnit.SECONDS)) {
                pool.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            pool.shutdownNow();
        }
    }
}
