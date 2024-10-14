package school.faang.kingslanding;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    private static final int THREAD_POOL_SIZE = 2;
    private static final int MAX_TIME_WAIT = 100;
    public static void main(String[] args) {
        Knight first = new Knight("First");
        Knight second = new Knight("Second");

        first.addTrial(new Trial("First", "First_trial"));
        first.addTrial(new Trial("First", "Second_trial"));
        second.addTrial(new Trial("Second", "First_trial"));
        second.addTrial(new Trial("Second", "Second_trial"));

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        first.startTrials(executor);
        second.startTrials(executor);

        executor.shutdown();

        try {
            if(executor.awaitTermination(MAX_TIME_WAIT, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}