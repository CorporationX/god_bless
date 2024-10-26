package school.faang.supportanimals;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int THREAD_POOL_SIZE = 10;
    private static final int TOTAL_DONATIONS = 100;
    private static final double BASE_DONATION_AMOUNT = 10.0;
    private static final double DONATION_INCREMENT = 5.0;

    public static void main(String[] args) {
        Organization organization = new Organization();
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (int i = 1; i <= TOTAL_DONATIONS; i++) {
            int donationId = i;
            double donationAmount = BASE_DONATION_AMOUNT + (i % 5) * DONATION_INCREMENT;
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

