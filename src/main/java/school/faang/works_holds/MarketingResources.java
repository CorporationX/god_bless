package school.faang.works_holds;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MarketingResources {
    private static final List<String> marketingResources = new ArrayList<>(List.of("marketing1, marketing2"));
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public void addFile(String file) {
        lock.writeLock().lock();
        try {
            marketingResources.add(file);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public List<String> getMarketingResources() {
        lock.readLock().lock();
        try {
            return marketingResources;
        } finally {
            lock.readLock().unlock();
        }
    }
}
