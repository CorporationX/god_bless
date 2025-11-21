package school.faang.dontionAnimals;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.DoubleAdder;

public class Organization {
    private final DoubleAdder totalBalance = new DoubleAdder();

    public void addDonation(Donation donation) {
        totalBalance.add(donation.getAmount()); // потокобезопасно
    }

    public double getBalance() {
        return totalBalance.doubleValue();
    }
}

class Main {
    public static void main(String[] args) throws InterruptedException {
        Organization org = new Organization();
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            final int threadId = i;
            threads[i] = new Thread(() -> {
                Donation donation = new Donation(threadId, 100.0 * (threadId + 1));
                org.addDonation(donation);
            });
            threads[i].start();
        }
        for (Thread t : threads) {
            t.join();
        }
        System.out.println("Final balance: " + org.getBalance());
    }
}