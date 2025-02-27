package school.faang.sprint4.bjs2_63071;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        final int numberOfThreads = 10;
        Organization organization = new Organization();
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        for (int i = 0; i < numberOfThreads; i++) {
            executorService.submit(() -> {
                for (int j = 0; j < 1000; j++) {
                    int id = j % 100;
                    Donation donation = new Donation(id, 1.0);
                    organization.addDonation(donation);
                }
            });
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executorService.shutdownNow();
        }

        System.out.println("Итоговый баланс: " + organization.getBalance());
    }
}
