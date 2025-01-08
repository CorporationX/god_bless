package school.faang.bjs251771;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;


@Slf4j
public class Main {

    public static final int COUNT_ACCOUNTS = 1_000;
    public static final String OUT_TEMPLATE = "The number of subscribers to {}'s account is {} followers.";
    public static final int NUMBER_THREADS = 5;

    public static void main(String[] args) {

        TwitterAccount account = new TwitterAccount("Bob", 111);
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();

        CompletableFuture<?>[] futuresArray = getCompletableFutures(system, account);

        CompletableFuture.allOf(futuresArray)
                .thenRun(() -> log.info(OUT_TEMPLATE, account.getUsername(), account.getFollowers()))
                .join();
    }

    private static CompletableFuture<?>[] getCompletableFutures(TwitterSubscriptionSystem system,
                                                                TwitterAccount account) {
        List<CompletableFuture<Void>> futuresList = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_THREADS);

        IntStream.range(0, COUNT_ACCOUNTS).forEach(v -> futuresList.add(system.followAccount(account, executor)));

        futuresList.forEach(CompletableFuture::join);
        executor.shutdown();

        return futuresList.toArray(new CompletableFuture[0]);
    }
}
