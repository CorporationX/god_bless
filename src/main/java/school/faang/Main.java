package school.faang;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_POOL_SIZE = 4;
    private static final ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    private static final int MIN_DONATION_VALUE = 10;
    private static final int MAX_DONATION_VALUE = 1000;
    private static final int TIMEOUT_SECONDS = 10;

    public static void main(String[] args) {
        Organization organization = new Organization();
        for (int i = 0; i < 10; ++i) {
            double donationValue = MIN_DONATION_VALUE +
                    (Math.random() * (MAX_DONATION_VALUE - MIN_DONATION_VALUE));
            int finalI = i;
            executor.submit(() -> organization.addDonation(new Donation(finalI, donationValue)));
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                log.warn("Not all tasks have been completed on time.");
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            log.error("awaitTermination was interrupted.");
        }
    }
}
