package school.faang.support.animals;

import lombok.Getter;

import java.util.concurrent.locks.ReentrantLock;

public class Organization {
    private final ReentrantLock lock = new ReentrantLock();

    @Getter
    private double balance;

    public void addDonation(Donation donation) {
        lock.lock();
        try {
            balance += donation.amount();
        } finally {
            lock.unlock();
        }
    }
}
