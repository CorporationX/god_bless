package school.faang.support_animals_BJS2_40112;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Organization {
    private Set<Donation> donations = new HashSet<>();
    ReadWriteLock lock = new ReentrantReadWriteLock();

    public void addDonation(Donation donation) {
        lock.writeLock().lock();
        try {
            donations.add(donation);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public double getTotalDonations() {
        lock.readLock().lock();
        try {
            return donations.stream()
                    .mapToDouble(Donation::getAmount)
                    .sum();
        } finally {
            lock.readLock().unlock();
        }
    }
}