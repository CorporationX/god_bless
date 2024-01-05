package WWF;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        Organization organization = new Organization();

        for (int i = 0; i < 1000000; i++) {
            executorService.submit(() -> organization.addDonation(new Donation(100)));
        }

        executorService.awaitTermination(5, TimeUnit.SECONDS);

        executorService.shutdown();

        System.out.println(organization.getBalance().get());
    }
}
