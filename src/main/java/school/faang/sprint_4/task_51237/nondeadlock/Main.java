package school.faang.sprint_4.task_51237.nondeadlock;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Slf4j
public class Main {
    private static final int NUMBER_OF_REPEATS = 10;
    private static final int AWAIT_ON_FUTURE = 1;

    public static void main(String[] args) {
        DesignResources designResources = new DesignResources();
        designResources.addFileName("deadlock.txt");
        MarketingResources marketingResources = new MarketingResources();
        marketingResources.addFileName("nonDeadlock.txt");

        DesignDepartment designDepartment = new DesignDepartment(designResources, marketingResources);
        MarketingDepartment marketingDepartment = new MarketingDepartment(designResources, marketingResources);
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_REPEATS; i++) {
            futures.add(CompletableFuture.runAsync(designDepartment));
            futures.add(CompletableFuture.runAsync(marketingDepartment));
        }

        for (CompletableFuture<Void> future : futures) {
            try {
                future.get(AWAIT_ON_FUTURE, TimeUnit.SECONDS);
            } catch (TimeoutException e) {
                log.info("Waiting timed out. Probably deadlock expired.");
            } catch (ExecutionException | InterruptedException e) {
                log.info("Exception occurred: {}", e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }
}
