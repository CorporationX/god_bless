package school.faang.sprint4.bjs2_62893;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DesignResources {
    private final List<String> files = new ArrayList<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public List<String> readFiles() {
        lock.readLock().lock();
        try {
            return files;
        } finally {
            lock.readLock().unlock();
        }
    }

    public void writeFile(String file) {
        lock.writeLock().lock();
        try {
            files.add(file);
        } finally {
            lock.writeLock().unlock();
        }
    }
}
