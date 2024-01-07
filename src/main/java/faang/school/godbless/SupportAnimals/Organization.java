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

        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 1; i < 10; i++) {
            int finalI = i;
            executor.submit(() -> {
                organization.addDonation(new Donation(finalI, finalI * 100));
                System.out.println("Добавляем " + finalI * 100 + " в потоке " + Thread.currentThread().getName());
            });
        }
        executor.shutdown();
        executor.awaitTermination(20, TimeUnit.SECONDS);

        System.out.println("Баланс организации: " + organization.balance);
    }
}
