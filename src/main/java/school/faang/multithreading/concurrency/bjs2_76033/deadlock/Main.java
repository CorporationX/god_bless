package school.faang.multithreading.concurrency.bjs2_76033.deadlock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREADS_AMOUNT = 2;

    public static void main(String[] args) {
        DesignResources designResources = new DesignResources();
        MarketingResources marketingResources = new MarketingResources();

        DesignDepartment designDepartment = new DesignDepartment(marketingResources, designResources);
        MarketingDepartment marketingDepartment = new MarketingDepartment(marketingResources, designResources);

        ExecutorService pool = Executors.newFixedThreadPool(THREADS_AMOUNT);
        pool.execute(designDepartment);
        pool.execute(marketingDepartment);

        pool.shutdown();

        try {
            if (!pool.awaitTermination(10, TimeUnit.SECONDS)) {
                log.warn("Force Termination.");
                pool.shutdownNow();
            } else {
                log.info("Execution is successfully finished.");
            }
        } catch (InterruptedException e) {
            log.error("Force Termination. InterruptedException = {}", e.getMessage());
            pool.shutdownNow();
        }
    }
}
