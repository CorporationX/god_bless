package faang.school.godbless.BJS2_25446;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MarketingDepartment extends ThreadDepartment {

    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public MarketingDepartment(MarketingResources marketingResources, DesignResources designResources) {
        super(marketingResources, designResources);
    }

    @Override
    public void run() {
        lock.readLock().lock();
        try {
            getMarketingResources().getResources();
            lock.readLock().lock();
            try {
                getDesignResources().getResources();
            } finally {
                lock.readLock().unlock();
            }
        } finally {
            lock.readLock().unlock();
        }
    }
}
