package supportanimals;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Organization organization = new Organization();
        int numberOfVolunteers = 5;
        int numberOfDonationsPerVolunteer = 10;
        ExecutorService executor = Executors.newFixedThreadPool(numberOfVolunteers);
        Random random = new Random();

        for (int i = 0; i < numberOfVolunteers; i++) {
            executor.submit(() -> {
                for (int j = 0; j < numberOfDonationsPerVolunteer; j++) {
                    double donationAmount = random.nextDouble() * 100;
                    Donation donation = new Donation(donationAmount);
                    organization.addDonation(donation);
                    System.out.printf("%s: donated %.2f%n", Thread.currentThread().getName(), donationAmount);
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("\n Balance of organization: " + organization.getBalance());
    }
}
