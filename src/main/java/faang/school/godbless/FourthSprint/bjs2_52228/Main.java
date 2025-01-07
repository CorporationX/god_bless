package faang.school.godbless.FourthSprint.bjs2_52228;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Organization organization = new Organization();

        for (int i = 0; i < 10; i++) {
            int donationId = i;
            executor.submit(() -> organization
                    .addDonation(new Donation(donationId
                            , ThreadLocalRandom.current().nextDouble(0, 100))));
        }

        while (!executor.awaitTermination(1, TimeUnit.SECONDS)){
            break;
        }
        System.out.println(organization.getBalance().doubleValue());
        executor.shutdown();
    }
}
