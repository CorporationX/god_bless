package faang.school.godbless.task.multithreading.async.twitter.selebrity;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int NUMBER_OF_SUBSCRIPTION = 25;
    private static final int THREAD_POOL_SIZE = NUMBER_OF_SUBSCRIPTION;

    private static final TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem(THREAD_POOL_SIZE);
    private static final List<CompletableFuture<Void>> futures = new ArrayList<>();
    private static TwitterAccount celebrity = new TwitterAccount("Elon Musk");

    public static void main(String[] args) {
        futures.addAll(runTask());
        printResult();
        subscriptionSystem.executorShutdown();
    }

    private static List<CompletableFuture<Void>> runTask() {
        return IntStream
                .range(0, NUMBER_OF_SUBSCRIPTION)
                .mapToObj(i -> subscriptionSystem.followAccount(celebrity))
                .toList();
    }

    private static void printResult() {
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> log.info("{} have {} new followers", celebrity.getUsername(), celebrity.getFollowers()));
    }
}
