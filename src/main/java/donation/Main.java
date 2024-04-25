package donation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int AMOUNT_OF_THREADS = 10;
    private static final ExecutorService SERVICE = Executors.newFixedThreadPool(AMOUNT_OF_THREADS);

    public static void main(String[] args) {
        Organization organization = new Organization();

        for (int i = 0; i < 50; i++) {
            SERVICE.execute(() -> organization.addDonation(new Donation(5_000_000)));
        }

        SERVICE.shutdown();
        try {
            SERVICE.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("All sum of donations: " + organization.getBalance());
    }
}
