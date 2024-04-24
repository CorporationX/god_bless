package faang.school.godbless.twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final int NUM_THREADS = 6;

    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(NUM_THREADS);
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        TwitterAccount max = new TwitterAccount("Max", 0);
        TwitterAccount nikita = new TwitterAccount("Nikita", 0);

        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem(pool);

        for (int i = 0; i < 1000; i++) {
            futures.add(system.followAccount(max));
            if (i > 500) {
                futures.add(system.followAccount(nikita));
            }
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        pool.shutdown();

        System.out.println("Max's subscrides: " + max.getFollowers());
        System.out.println("Nikita's subscrides: " + nikita.getFollowers());
    }
}
