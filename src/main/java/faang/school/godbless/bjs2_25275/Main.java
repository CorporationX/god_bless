package faang.school.godbless.bjs2_25275;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.concurrent.TimeUnit.MINUTES;

@Slf4j
public class Main {
    private static final int THREAD_POOL_SIZE = 10;
    private static final int DONATIONS_AMOUNT = THREAD_POOL_SIZE;
    private static final double MIN_AMOUNT = 00.01D;
    private static final double MAX_AMOUNT = 999.99D;

    public static void main(String[] args) {
        Organization organization = new Organization();
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (int i = 1; i <= DONATIONS_AMOUNT; i++) {
            var donation = createDonation(i);
            executorService.execute(() -> {
                organization.addDonation(donation);
            });
        }

        shutdownAndAwait(executorService);

        log.info("Organisation balance: {}", organization.getBalance());
    }

    private static Donation createDonation(int i) {
        double randomAmount = ThreadLocalRandom.current().nextDouble(MIN_AMOUNT, MAX_AMOUNT);
        double roundedAmount = Math.round(randomAmount * 100.0) / 100.0;
        return new Donation(i, roundedAmount);
    }

    private static void shutdownAndAwait(ExecutorService executorService) {
        executorService.shutdown();

        try {
            executorService.awaitTermination(1, MINUTES);
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted");
        }
    }
}
