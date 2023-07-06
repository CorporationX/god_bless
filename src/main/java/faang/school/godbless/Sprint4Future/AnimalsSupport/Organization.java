package faang.school.godbless.Sprint4Future.AnimalsSupport;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Organization {
    private AtomicInteger balance = new AtomicInteger(0);

    public static void main(String[] args) {
        Organization organization = new Organization();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10000; i++) {
            executorService.execute(()-> organization.addDonation(new Donation(1,100)));
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(organization.balance);
    }

    public void addDonation(Donation donation){
        balance.addAndGet(donation.getAmount());
    }

}
