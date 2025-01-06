package school.faang.task_51307;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int TERMINATION_TIMEOUT = 10;
    private static final int NUM_THREADS = 2;

    public static void main(String[] args) {
        DesignResources designResources = new DesignResources();
        MarketingResources marketingResources = new MarketingResources();

        for (int i = 1; i <= 3; i++) {
            designResources.addFileName("Some design file " + i);
            marketingResources.addFileName("Some marketing file " + i);
        }

        DesignDepartment designDepartment = new DesignDepartment(designResources, marketingResources);
        MarketingDepartment marketingDepartment = new MarketingDepartment(marketingResources, designResources);

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        executorService.execute(designDepartment);
        executorService.execute(marketingDepartment);

        executorService.shutdown();
        try {
            if (executorService.awaitTermination(TERMINATION_TIMEOUT, TimeUnit.SECONDS)) {
                log.info("All tasks successfully completed");
            } else {
                executorService.shutdownNow();
                log.error("Tasks are not completed");
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}
