package faang.school.godbless.animals;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 1000;
    private static final ExecutorService service = Executors.newFixedThreadPool(NUM_THREADS);

    public static void main(String[] args) {
        Organization organization = new Organization(0);

        for (int i = 0; i < NUM_THREADS; i++) {
            int finalI = i;
            service.execute(() -> organization.addDonation(
                    new Donation(finalI, 1_000)
            ));
        }

        service.shutdown();
        try {
            if (!service.awaitTermination(NUM_THREADS * 2, TimeUnit.MILLISECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
        }

        System.out.println(organization.getBalance());
    }
}
