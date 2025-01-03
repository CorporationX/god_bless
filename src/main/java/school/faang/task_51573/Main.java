package school.faang.task_51573;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int TERMINATION_TIMEOUT = 30;
    private static final int NUM_THREADS = 5;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        Organization organization = new Organization();

        for (int i = 1; i < 6; i++) {
            Donation donation = new Donation(i * 100);
            executorService.execute(() -> organization.addDonation(donation));
        }

        executorService.shutdown();
        try {
            if (executorService.awaitTermination(TERMINATION_TIMEOUT, TimeUnit.SECONDS)) {
                log.info("Total donation amount: {}", organization.getTotalDonationAmount());
                log.info("All tasks completed successfully");
            } else {
                log.info("Tasks are not completed");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}
