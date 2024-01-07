package faang.school.godbless.SupportAnimals;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Organization {
    private AtomicInteger balance = new AtomicInteger(0);

    private void addDonation(Donation donation) {
        balance.addAndGet(donation.getSum());
    }

    public static void main(String[] args) throws InterruptedException {
        Organization organization = new Organization();

        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 1; i < 5; i++) {
            int finalI = i;
            executor.submit(() ->
                    organization.addDonation(new Donation(finalI, finalI * 100)));
        }executor.shutdown();
        executor.awaitTermination(20, TimeUnit.SECONDS);


        System.out.println("Баланс организации: " + organization.balance);
    }
}
