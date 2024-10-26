package school.faang.stopwork;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@AllArgsConstructor
public class MarketingResources {
    private List<String> files;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

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
