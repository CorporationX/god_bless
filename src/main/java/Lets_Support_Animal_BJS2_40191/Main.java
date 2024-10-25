package Lets_Support_Animal_BJS2_40191;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Organization organization = new Organization();
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        AtomicInteger donationIdGenerator = new AtomicInteger(0);

        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                int id = donationIdGenerator.incrementAndGet();
                Donation donation = new Donation(id, Math.random() * 10);
                organization.addDonation(donation);
            });

            executorService.shutdown();
            while (!executorService.isTerminated()) {
                Thread.sleep(1000);
            }

            System.out.println("Balance of organization: " + organization.getBalance());
        }
    }
}