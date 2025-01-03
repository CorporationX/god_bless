package school.faang.task51404;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MarketingResources {
    private final List<String> files = new ArrayList<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public void addFile(String file) {
        lock.readLock().lock();
        try {
            files.add(file);
        } finally {
            lock.readLock().unlock();
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
