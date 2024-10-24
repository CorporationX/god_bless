package animals;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int TREAD_COUNT = 2;

    public static void main(String[] args) {
        Donation donation1 = new Donation(1, 34.5);
        Donation donation2 = new Donation(2, 21.4);
        Donation donation3 = new Donation(3, 78.6);
        Organization organization = new Organization();
        ExecutorService executorService = Executors.newFixedThreadPool(TREAD_COUNT);
        executorService.submit(() -> organization.addDonation(donation1));
        executorService.submit(() -> organization.addDonation(donation2));
        executorService.submit(() -> organization.addDonation(donation3));
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
