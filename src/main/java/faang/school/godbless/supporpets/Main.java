package faang.school.godbless.supporpets;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int N_THREADS = 10;
    private static final int DONATIONS_COUNT = 100;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(N_THREADS);
        Organization organization = new Organization();
        for (int i = 0; i < DONATIONS_COUNT; i++) {
            executorService.execute(() -> {
                int random = ThreadLocalRandom.current().nextInt(1, 10);
                organization.addDonation(new Donation(10000 * random));
            });
        }

        executorService.shutdown();

        while (!executorService.awaitTermination(20, TimeUnit.SECONDS)) {
        }

        organization.logBalance();
    }
}
