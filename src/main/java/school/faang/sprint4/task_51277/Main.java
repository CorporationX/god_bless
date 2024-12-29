package school.faang.sprint4.task_51277;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_POOL_SIZE = 2;

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        DesignResources designResources = new DesignResources();
        MarketingResources marketingResources = new MarketingResources();

        Runnable marketing = new MarketingDepartment(designResources, marketingResources);
        Runnable design = new DesignDepartment(designResources, marketingResources);

        pool.submit(marketing);
        pool.submit(design);

        pool.shutdown();
        try {
            if (!pool.awaitTermination(5, TimeUnit.SECONDS)) {
                pool.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
