package school.faang.support;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_COUNT = 10;
    private static final int WAIT_TIME = 5;

    public static void main(String[] args) throws InterruptedException {
        Organization org = new Organization();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

        for (int i = 1; i <= 100; i++) {
            final int donationId = i;
            executor.submit(() -> {
                Donation donation = new Donation(donationId, 100.0);
                org.addDonation(donation);
            });
        }

        for (int i = 90; i <= 110; i++) {
            final int duplicateId = i;
            executor.submit(() -> {
                Donation donation = new Donation(duplicateId, 100.0);
                org.addDonation(donation);
            });
        }

        executor.shutdown();
        executor.awaitTermination(WAIT_TIME, TimeUnit.SECONDS);

        log.info("The final balance {} ", org.getTotalBalance());
    }
}
