package school.faang.helpanimal;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final ExecutorService EXECUTOR =
            Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private static final int COUNT_DONATIONS = 1000;
    private static final List<Donation> DONATIONS = new ArrayList<>(COUNT_DONATIONS);
    private static final List<CompletableFuture<Void>> FUTURES = new ArrayList<>(COUNT_DONATIONS);
    private static final Organization ORGANIZATION = new Organization();
    private static final int MAX_DONATION = 1000;
    private static final int MIN_DONATION = 500;
    private static final int TIME_EXECUTION = 1;
    private static final TimeUnit TIME_UNIT = TimeUnit.MINUTES;

    public static void main(String[] args) {
        try {
            for (int i = 0; i < COUNT_DONATIONS; i++) {
                createDonation();
            }
            DONATIONS.forEach(donation -> FUTURES.add(CompletableFuture
                    .runAsync(() -> ORGANIZATION.addDonation(donation), EXECUTOR)
                    .orTimeout(TIME_EXECUTION, TIME_UNIT)));
            CompletableFuture.allOf(FUTURES.toArray(CompletableFuture[]::new)).join();
            log.info("Total sum organization: {}", ORGANIZATION.totalSum().get());
            EXECUTOR.shutdown();
        } catch (CompletionException e) {
            log.error("Timed out {} {}", TIME_EXECUTION, TIME_UNIT);
            EXECUTOR.shutdownNow();
        }
    }

    private static void createDonation() {
        int sumDonation = MIN_DONATION + (int) (Math.random() * (MAX_DONATION - MIN_DONATION + 1));
        DONATIONS.add(new Donation(sumDonation));
    }
}
