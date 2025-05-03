package school.faang.works_holds;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public abstract class Resources {
    private final List<String> resources = new ArrayList<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public void addFile(String file) {
        lock.writeLock().lock();
        try {
            resources.add(file);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public List<String> getResources() {
        lock.readLock().lock();
        try {
            return new ArrayList<>(resources);
        } finally {
            lock.readLock().unlock();
        }
    }
}
