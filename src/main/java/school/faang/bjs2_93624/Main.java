package school.faang.bjs2_93624;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_COUNT = 5;

    public static void main(String[] args) throws InterruptedException {
        Organization organization = new Organization();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        Random random = new Random();

        for (int i = 0; i < THREAD_COUNT; i++) {
            executor.submit(() -> {
                double amount = Math.round(random.nextDouble(100.00) * 100.0) / 100.0;
                int id = random.nextInt(1000);
                Donation donation = new Donation(id, amount);
                organization.addDonation(donation);
            });
        }
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        organization.getDonationCounter();
        organization.getBalance();
        organization.printAllDonations();
    }
}
