package faang.school.godbless.celeba;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private final static int NUM_THREADS = 1312;
    private static ExecutorService service = Executors.newFixedThreadPool(NUM_THREADS);
    private static TwitterSubscriptionSystem  system = new TwitterSubscriptionSystem();
    public static void main(String[] args) {
        List<CompletableFuture<Void>> futures = new ArrayList<>(200);

        TwitterAccount account = new TwitterAccount("account", new AtomicInteger(100));

        for (int i = 0; i < NUM_THREADS; i++) {
            futures.add(followAccount(account));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(
                        () -> System.out.println(account.getFollowers())
                );

        service.shutdown();
    }

    private static CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(
                () -> system.addFollower(account),
                service
        );
    }
}
