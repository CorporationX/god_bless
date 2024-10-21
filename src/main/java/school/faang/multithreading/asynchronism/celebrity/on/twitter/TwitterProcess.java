package school.faang.multithreading.asynchronism.celebrity.on.twitter;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
public class TwitterProcess {
    private static final int NUMBER_OF_SUBSCRIBERS = 999;

    public static void main(String[] args) {
        TwitterSubscriptionSystem subscription = new TwitterSubscriptionSystem();
        TwitterAccount account = new TwitterAccount("username1");
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        IntStream.range(0, NUMBER_OF_SUBSCRIBERS)
                .forEach(i -> futures.add(CompletableFuture.runAsync(() -> subscription.followAccount(account))));

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> log.info("Количество подписчиков учетной записи: {}", account.getFollowers()))
                .join();
    }
}
