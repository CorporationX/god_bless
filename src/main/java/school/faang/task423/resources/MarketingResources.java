package school.faang.task423.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MarketingResources {
    private final List<String> files = new ArrayList<>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void addFile(String file) {
        lock.writeLock().lock();
        try {
            files.add(file);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public List<String> getFiles() {
        lock.readLock().lock();
        try {
            return files;
        } finally {
            lock.readLock().unlock();
        }
    }
}
