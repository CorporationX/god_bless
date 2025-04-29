package school.faang.twitter;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    static TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();

    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("Иоша", 999999);

        batchFollow(account, 1111);
    }

    public static void batchFollow(TwitterAccount account, int count) {
        List<CompletableFuture<Void>> futures = IntStream.range(0, count)
                .mapToObj(i -> twitterSubscriptionSystem.followAccount(account))
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    log.info("Все подписки завершены. Итоговое количество подписчиков {}: {}",
                            account.getUsername(),
                            account.getFollowers());
                    twitterSubscriptionSystem.shutdown();
                })
                .exceptionally(ex -> {
                    log.error("Ошибка при обработке подписок", ex);
                    twitterSubscriptionSystem.shutdown();
                    return null;
                })
                .join();
    }
}
