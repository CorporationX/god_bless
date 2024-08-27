package faang.school.godbless.helpingAnimals;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Organization organization = new Organization();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            executorService.submit(() -> organization.addDonation(new Donation(finalI, finalI * 100)));
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

        //5500
        System.out.println("Total balance: " + organization.getBalance());
    }
}
