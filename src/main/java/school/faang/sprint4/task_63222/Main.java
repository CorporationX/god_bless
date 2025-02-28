package school.faang.sprint4.task_63222;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final Organization ORGANIZATION = new Organization();
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(3);
    private static final int WAITING_DONATIONS = 1;
    private static final int DONATION_COUNT = 10;
    private static final double DONATION_AMOUNT = 100D;
    private static final String CLOSE_POOL_FORM = "The thread pool was closed";

    public static void main(String[] args) {
        IntStream.range(0, DONATION_COUNT)
                .mapToObj(num -> new Donation(DONATION_AMOUNT))
                .forEach(donation ->
                        EXECUTOR.submit(() -> ORGANIZATION.addDonation(donation)));

        closeExecutor();
        log.info("The sum of all donations is {}", ORGANIZATION.getAmount());
    }

    private static void closeExecutor() {
        EXECUTOR.shutdown();
        try {
            if (!EXECUTOR.awaitTermination(WAITING_DONATIONS, TimeUnit.SECONDS)) {
                EXECUTOR.shutdownNow();
                log.info(CLOSE_POOL_FORM);
            }
        } catch (InterruptedException e) {
            EXECUTOR.shutdownNow();
            log.error("{} with an exception", CLOSE_POOL_FORM, e);
        }
    }
}
