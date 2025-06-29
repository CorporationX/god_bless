package school.faang.bjs2_82997;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_POOL_SIZE = 10;
    private static final int TOTAL_DONATIONS = 100;
    private static final int MAX_WAIT_SECONDS = 5;

    public static void main(String[] args) {
        Organization organization = new Organization();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (int i = 1; i <= TOTAL_DONATIONS; i++) {
            final int donationId = i;
            executor.submit(() -> {
                double amount = Math.random() * 1000;
                Donation donation = new Donation(donationId, amount);
                organization.addDonation(donation);
                System.out.printf("Donation %d added: %.2f%n", donationId, amount);
            });
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(MAX_WAIT_SECONDS, TimeUnit.SECONDS)) {
                System.out.printf("Not all tasks completed in %d seconds. Forcing shutdown...%n", MAX_WAIT_SECONDS);
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.err.println("Thread termination was interrupted.");
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.printf("Final organization balance: %.2f%n", organization.getBalance());
    }
}
