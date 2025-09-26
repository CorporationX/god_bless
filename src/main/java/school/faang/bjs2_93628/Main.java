package school.faang.bjs2_93628;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    private static final int SIZE_POOL_THREAD = 10;
    private static final int SLEEP_WAITING = 5;
    private static final int COUNT_DONAT_OPERATION = 30;
    private static final int MIN_DONAT = 10;
    private static final int MAX_DONAT = 1000;
    private static final Random random = new Random();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(SIZE_POOL_THREAD);
        Organization organization = new Organization();
        IntStream.rangeClosed(1, COUNT_DONAT_OPERATION)
                .forEach(i -> {
                    int sum = random.nextInt(MIN_DONAT, MAX_DONAT);
                    executor.submit(() -> organization.addDonation(new Donation(i, sum)));
                });

        executor.shutdown();

        try {
            if (!executor.awaitTermination(SLEEP_WAITING, TimeUnit.MINUTES)) {
                executor.shutdown();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        organization.printBalance();
        organization.printHistoryDonat();
    }
}
