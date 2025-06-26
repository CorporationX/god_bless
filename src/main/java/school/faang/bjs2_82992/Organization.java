package school.faang.bjs2_82992;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
@RequiredArgsConstructor
public class Organization {
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private double finance;
    @Getter
    private final String name;

    public void addDonation(Donation donation) {
        lock.writeLock().lock();
        log.info("Аноним перечислил {} на счет организации {}", donation, name);
        finance += donation.getAmount();
        lock.writeLock().unlock();
    }

    public double getFinance() {
        lock.readLock().lock();
        try {
            return finance;
        } finally {
            lock.readLock().unlock();
        }
    }
}
