package school.faang.bjs2_92599;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int COUNT_THREAD = 4;
    private static ExecutorService executor = Executors.newFixedThreadPool(COUNT_THREAD);

    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();

        try {
            masterCardService.doAll(executor);
        } finally {
            shutdown();
        }
    }

    private static void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
