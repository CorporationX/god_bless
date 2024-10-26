package dima.evseenko.support;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Organization org = new Organization();

        ExecutorService executorService = Executors.newCachedThreadPool();

        getDonations().forEach(donation -> executorService.submit(() -> org.addDonation(donation)));

        executorService.shutdown();

        if (executorService.awaitTermination(100, TimeUnit.SECONDS)) {
            System.out.println(org.getTotalAmount());
        }
    }

    private static List<Donation> getDonations() {
        return List.of(
                new Donation(1, 100),
                new Donation(2, 50),
                new Donation(3, 30),
                new Donation(4, 70)
        );
    }
}
