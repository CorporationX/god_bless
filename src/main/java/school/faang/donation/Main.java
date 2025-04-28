package school.faang.donation;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {
    private static final int THREADS_COUNT = 10;
    private static final int DONATIONS_THREAD = 100;
    private static final double MIN_DONATION = 10.0;
    private static final double MAX_DONATION = 100.0;
    private static final long SHUTDOWN_TIMEOUT_MINUTES = 1;

    public static void main(String[] args) throws InterruptedException {
        Organization organization = new Organization();
        ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);
        AtomicInteger idGenerator = new AtomicInteger(1);

        for (int i = 0; i < THREADS_COUNT; i++) {
            executor.execute(() -> {
                for (int j = 0; j < DONATIONS_THREAD; j++) {
                    double sum = ThreadLocalRandom.current().nextDouble(MIN_DONATION, MAX_DONATION);
                    organization.addDonation(new Donation(idGenerator.getAndIncrement(), sum));
                }
            });
        }

        executor.shutdown();
        boolean completed = executor.awaitTermination(SHUTDOWN_TIMEOUT_MINUTES, TimeUnit.MINUTES);
        if (!completed) {
            log.error("Не все потоки завершились за отведенное время.");
        }


        log.info("Общий баланс: {} (количество донатов {})",
                organization.getBalance(),
                organization.getProcessedDonations().size()
        );
    }
}
