package school.faang.multithreading.concurr.deadlock.read.write.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MarketingResources {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final List<String> fileNames = new ArrayList<>();

    public List<String> getFilesNames() {
        lock.readLock().lock();
        try {
            return fileNames;
        } finally {
            lock.readLock().unlock();
        }
    }

    public void addFileName(String name) {
        lock.writeLock().lock();
        try {
            fileNames.add(name);
        } finally {
            lock.writeLock().unlock();
        }
    }
}
