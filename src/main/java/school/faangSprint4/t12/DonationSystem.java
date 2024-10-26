package school.faangSprint4.t12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DonationSystem {
    private static final int AWAIT_TIMEOUT = 10;
    public static void main(String[] args) {
        Organization organization = new Organization();
        int numberOfThreads = 5;
        int donationsPerThread = 100;

        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++) {
            final int threadNumber = i;
            executorService.submit(() -> {
                for (int j = 0; j < donationsPerThread; j++) {
                    int donationId = threadNumber * donationsPerThread + j;
                    double amount = 1 + Math.random() * 99;
                    Donation donation = new Donation(donationId, amount);
                    organization.addDonation(donation);

                    System.out.printf("Thread %d: Added donation #%d with amount %.2f%n",
                            threadNumber, donationId, amount);
                }
            });
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(AWAIT_TIMEOUT, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("Thread execution was interrupted");
        }

        System.out.printf("%nFinal balance: %.2f%n", organization.getBalance());
    }
}