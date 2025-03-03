package school.faang.helpanimal;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final ExecutorService EXECUTOR =
            Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private static final int COUNT_DONATIONS = 1000;
    private static final List<Donation> DONATIONS = new ArrayList<>(COUNT_DONATIONS);
    private static final List<CompletableFuture<Void>> FUTURES = new ArrayList<>(COUNT_DONATIONS);
    private static final Organization ORGANIZATION = new Organization();
    private static final int MAX_DONATION = 2000;
    private static final int MIN_DONATION = 500;
    private static final int TIME_EXECUTION = 1;
    private static final TimeUnit TIME_UNIT = TimeUnit.MINUTES;
    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public static void main(String[] args) {
        try {
            for (int i = 0; i < COUNT_DONATIONS; i++) {
                createDonation();
            }
            DONATIONS.forEach(donation -> FUTURES.add(CompletableFuture
                    .runAsync(() -> ORGANIZATION.addDonation(donation), EXECUTOR)
                    .orTimeout(TIME_EXECUTION, TIME_UNIT)));
            CompletableFuture.allOf(FUTURES.toArray(CompletableFuture[]::new)).join();
            log.info("Total sum organization: {}", ORGANIZATION.getTotalSum().get());
            EXECUTOR.shutdown();
        } catch (CompletionException e) {
            log.error("Timed out {} {}", TIME_EXECUTION, TIME_UNIT);
            EXECUTOR.shutdownNow();
        }
    }

    private static void createDonation() {
        BigDecimal sumDonation =
                BigDecimal.valueOf(MIN_DONATION + (RANDOM.nextInt(MAX_DONATION - MIN_DONATION)));
        DONATIONS.add(new Donation(sumDonation));
    }
}
