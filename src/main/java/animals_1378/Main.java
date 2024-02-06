package animals_1378;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {

        Organization organization = new Organization(new AtomicInteger());
        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 1; i < 10; i++) {
            service.execute(() -> {
                int id = 10;
                organization.addDonation(new Donation(id, (int) (Math.random() * 100)));
            });
        }
        service.shutdown();

        try {
            service.awaitTermination(10, TimeUnit.SECONDS);
            System.out.println("Общий баланс - " + organization.getBalance());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}