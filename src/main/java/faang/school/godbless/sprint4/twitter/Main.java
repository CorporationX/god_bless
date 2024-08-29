package faang.school.godbless.sprint4.twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {
    private static final int QUANTITY_OF_SUBSCRIPTIONS = 1000;
    private static final TwitterAccount celebrity = new TwitterAccount("Celebrity");
    private static final TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();
    private static final List<CompletableFuture<Void>> futures = new ArrayList<>(QUANTITY_OF_SUBSCRIPTIONS);
    private static final ExecutorService executor = Executors.newFixedThreadPool(QUANTITY_OF_SUBSCRIPTIONS);

    public static void main(String[] args) {
        createFutures();
        CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new))
                .thenRun(() -> System.out.printf("Account of %s have %d followers%n", celebrity.getUsername(), celebrity.getFollowers()));
        executor.shutdown();
    }

    private static void createFutures() {
        IntStream.rangeClosed(1, QUANTITY_OF_SUBSCRIPTIONS)
                .mapToObj(number -> twitterSubscriptionSystem.followAccount(celebrity, executor))
                .forEach(futures::add);
    }
}
