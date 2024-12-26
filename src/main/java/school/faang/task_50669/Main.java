package school.faang.task_50669;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_POOL_SIZE = 5;
    private static final int AWAIT_TERMINTAION_TIME = 60;

    public static void main(String[] args) {
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        TwitterAccount account = new TwitterAccount("Ilon Musk", 0);
        system.addFollowers(account, executor);

        executor.shutdown();
        try {
            if (!executor.awaitTermination(AWAIT_TERMINTAION_TIME, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
