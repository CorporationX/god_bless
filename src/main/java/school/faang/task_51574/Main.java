package school.faang.task_51574;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int NUMBER_OF_THREADS = 8;
    private static final int TERMINATION_TIMEOUT_MILLIS = 100;

    private static final int TOTAL_DONATIONS = 20;
    private static final double MAX_DONATION_AMOUNT = 100.0;

    public static void main(String[] args) {
        Organization organization = new Organization();
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        CompletableFuture.allOf(
                IntStream.rangeClosed(1, TOTAL_DONATIONS)
                        .mapToObj(i -> {
                            Donation donation = new Donation(i, getRandomAmount());
                            return CompletableFuture.runAsync(() ->
                                    organization.addDonation(donation), executorService);
                        })
                        .toArray(CompletableFuture[]::new)
        ).thenRun(() -> {
            double balance = organization.getBalance();
            log.info("Final balance after processing donations: {}", balance);
        });

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(TERMINATION_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)) {
                log.info("All tasks completed successfully.");
            } else {
                log.warn("Some tasks did not finish in the allotted time.");
            }
        } catch (InterruptedException e) {
            log.error("Waiting for termination was interrupted. Attempting to shutdown now.", e);
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    private static double getRandomAmount() {
        return Math.random() * (MAX_DONATION_AMOUNT + 1);
    }

}
