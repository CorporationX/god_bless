package faang.school.godbless.TwitterCelebrity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Main {
    private static final int NUM_THREADS = 10;
    private static final int NUM_ACCOUNT = 100;

    public static void main(String[] args) {
        List<TwitterAccount> accounts = getAccounts();
        ExecutorService pool = Executors.newFixedThreadPool(NUM_THREADS);
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem(pool);

        List<CompletableFuture<Void>> tasks = new ArrayList<>();
        for (TwitterAccount account : accounts) {
            for (TwitterAccount account1 : accounts) {
                tasks.add(subscriptionSystem.followAccount(account));
                tasks.add(subscriptionSystem.followAccount(account1));
            }
        }
        pool.shutdown();

        CompletableFuture.allOf(tasks.toArray(CompletableFuture[]::new)).join();
        accounts.forEach(account -> System.out.println(account.getUsername() + ": " + account.getFollowers()));
    }

    private static List<TwitterAccount> getAccounts() {
        List<TwitterAccount> accounts = new ArrayList<>();
        IntStream.range(0, NUM_ACCOUNT).forEach(i -> accounts.add(new TwitterAccount(getId(i), new AtomicInteger(0))));
        return accounts;
    }

    private static String getId(int ind) {
        return "ID" + ind;
    }
}
