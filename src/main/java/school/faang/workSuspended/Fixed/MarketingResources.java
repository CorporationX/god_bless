package school.faang.workSuspended.Fixed;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MarketingResources {
    private final List<String> marketingFiles = new ArrayList<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public void addFile(String file) {
        lock.writeLock().lock();
        try {
            marketingFiles.add(file);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public List<String> getMarketingFiles() {
        lock.readLock().lock();
        try {
            return marketingFiles;
        } finally {
            lock.readLock().unlock();
        }
    }
}
