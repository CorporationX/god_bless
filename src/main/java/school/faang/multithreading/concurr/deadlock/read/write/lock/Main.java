package school.faang.multithreading.concurr.deadlock.read.write.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREADS_COUNT = 2;
    private static final ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);

    public static void main(String[] args) {
        MarketingResources marketingResources = new MarketingResources();
        DesignResources designResources = new DesignResources();

        MarketingDepartment marketingDepartment = new MarketingDepartment(marketingResources, designResources);
        DesignDepartment designDepartment = new DesignDepartment(designResources, marketingResources);

        executor.submit(marketingDepartment);
        executor.submit(designDepartment);

        shutdown();
        awaitTermination();
    }

    private static void shutdown() {
        executor.shutdown();
    }

    private static void awaitTermination() {
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
