package bjs2_37896;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int TOTAL_THREADS = 5;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(TOTAL_THREADS);
        Organization organization = new Organization();

        executorService.submit(() -> organization.addDonation(new Donation(0, 5000)));
        executorService.submit(() -> organization.addDonation(new Donation(1, 20000)));
        executorService.submit(() -> organization.addDonation(new Donation(2, 3000)));
        executorService.submit(() -> organization.addDonation(new Donation(3, 250)));
        executorService.submit(() -> organization.addDonation(new Donation(4, 10000)));
        executorService.submit(() -> organization.addDonation(new Donation(5, 150000)));

        executorService.shutdown();
        if (!executorService.awaitTermination(30, TimeUnit.SECONDS)) {
            System.out.println("Time limit reached. Forcing shutdown");
            executorService.shutdownNow();
        }

        System.out.println(organization.getBalance());
    }
}
