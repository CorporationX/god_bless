package faang.school.godbless.sprint4.animals;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Organization {
    private AtomicInteger balance = new AtomicInteger(0);

    public void addDonation(Donation donation) {
        balance.getAndAdd(donation.getAmount());
    }

    public static void main(String[] args) throws InterruptedException {
        Organization organization = new Organization();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 5; i++){
            int finalI = i;
            executor.submit(() -> {
                organization.addDonation(new Donation(1 + finalI, 100 + finalI));
            });

        }
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(organization.balance.get());
    }
}
