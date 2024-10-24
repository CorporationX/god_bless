package school.faang.supportanimals;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Organization organization = new Organization();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 1; i <= 100; i++) {
            int donationId = i;
            double donationAmount = 10.0 + (i % 5) * 5;
            executorService.submit(() -> {
                Donation donation = new Donation(donationId, donationAmount);
                organization.addDonation(donation);
                System.out.println("Donation added: ID = " + donation.getId() + ", Amount = $" + donation.getAmount());
            });
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }

        System.out.println("Final Total Balance: $" + organization.getTotalBalance());
    }
}

