package animals;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int TREAD_COUNT = 2;
    private static Random random = new Random();

    public static void main(String[] args) {
        Organization organization = new Organization();
        ExecutorService executorService = Executors.newFixedThreadPool(TREAD_COUNT);
        for (int i = 0; i < TREAD_COUNT; i++) {
            for (int j = 1; j < 4; j++) {
                Donation donation = new Donation(i, random.nextInt(100));
                executorService.submit(() -> organization.addDonation(donation));
            }
        }

        executorService.shutdown();
        try {
            if (executorService.awaitTermination(30, TimeUnit.SECONDS)) {
                double totalDonation = organization.getBalans().stream()
                        .mapToDouble(Donation::getAmount)
                        .sum();
                System.out.println("Total donation: " + totalDonation);
            } else {
                System.out.println("Not all tasks finished within the time limit");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
