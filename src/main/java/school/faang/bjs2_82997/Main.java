package school.faang.bjs2_82997;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Organization organization = new Organization();

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 1; i <= 100; i++) {
            final int donationId = i;
            executor.submit(() -> {
                double amount = Math.random() * 1000;
                Donation donation = new Donation(donationId, amount);
                organization.addDonation(donation);
                System.out.printf("Donation %d added: %.2f%n", donationId, amount);
            });
        }

        executor.shutdown();
        executor.awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS);

        System.out.printf("Final organization balance: %.2f%n", organization.getBalance());
    }
}
