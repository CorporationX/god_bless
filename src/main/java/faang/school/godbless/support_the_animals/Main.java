package faang.school.godbless.support_the_animals;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Organization organization = new Organization();

        List<Donation> donations = new ArrayList<>(Arrays.asList(
                new Donation(300),
                new Donation(330),
                new Donation(303),
                new Donation(334),
                new Donation(303),
                new Donation(532)
        ));

        donations
                .forEach(donation -> executor.submit(() -> {
                    try {
                        Thread.sleep(2000);
                        System.out.println(Thread.currentThread().getName() + " || Sum = " + donation.getSum());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    organization.addDonation(donation);
                }));

        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        organization.printBalance();
    }
}

@Getter
class Donation {
    private static int id = 0;
    private final int sum;

    public Donation(int sum) {
        this.sum = sum;
        id++;
    }
}

@Getter
class Organization {
    private final AtomicInteger balance = new AtomicInteger(0);

    public void addDonation(Donation donation) {
        balance.addAndGet(donation.getSum());
    }

    public void printBalance() {
        System.out.println("Всего на балансе = " + balance.get());
    }
}