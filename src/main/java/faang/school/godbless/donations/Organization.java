package faang.school.godbless.donations;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Organization {
    private long totalBalance = 0;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public void addDonation(Donation donation) {
        writeLock.lock();
        try {
            totalBalance += donation.getAmount();
            System.out.println("Пожертвование " + donation.getId() + " на сумму " + donation.getAmount() + " добавлено. Общий баланс: " + totalBalance);
        } finally {
            writeLock.unlock();
        }
    }

    public long getBalance() {
        readLock.lock();
        try {
            return totalBalance;
        } finally {
            readLock.unlock();
        }
    }
}

