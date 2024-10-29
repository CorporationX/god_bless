package becoming_a_celebrity_on_twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private final static int AWAIT_SECONDS = 30;
    private static final int MAX_THREADS = 2;
    private static final ExecutorService service = Executors.newFixedThreadPool(MAX_THREADS);

    /**
     * Follows each Twitter account in {@code twitterAccounts} and prints its number of followers.
     * @param args Command line arguments (not used)
     * @throws InterruptedException If the thread is interrupted while waiting for the executor service to terminate
     */
    public static void main(String[] args) throws InterruptedException {
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();

        List<TwitterAccount> twitterAccounts = List.of(
                new TwitterAccount("jack", 10),
                new TwitterAccount("jill", 20),
                new TwitterAccount("john", 30)
        );

        ArrayList<CompletableFuture<TwitterAccount>> allTasks = new ArrayList<>();

        twitterAccounts.forEach((twitterAccount) -> {
            allTasks.add(twitterSubscriptionSystem.followAccount(twitterAccount, service));
        });

        allTasks.forEach(CompletableFuture::join);

        twitterAccounts.forEach(twitterAccount -> System.out.println(twitterAccount.getUsername() + " has " + twitterAccount.getFollowers() + " followers"));

        service.shutdown();
        if (!service.awaitTermination(AWAIT_SECONDS, TimeUnit.SECONDS)) {
            service.shutdownNow();
        }
    }
}
