package support.animals;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int POOL_THREAD_SIZE = 10;
    private static final int DONATIONS_COUNT = 5;
    private static final int MAX_DONATE = 5000;

    public static void main(String[] args) {
        Organization organization = new Organization();
        ExecutorService executorService = Executors.newFixedThreadPool(POOL_THREAD_SIZE);

        for (int i = 0; i < DONATIONS_COUNT; i++) {
            executorService.execute(() -> {
                Random random = new Random();
                organization.addDonation(new Donation(random.nextInt(MAX_DONATE)));
            });
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Баланс организации: " + organization.getBalance());
    }
}
