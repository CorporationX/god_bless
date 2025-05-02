package school.faang.works_holds;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DesignResources {
    private static final List<String> designResources = new ArrayList<>(List.of("design1, design2"));
    private final ReadWriteLock lock = new ReentrantReadWriteLock();


    public void addFile(String file) {
        lock.writeLock().lock();
        try {
            designResources.add(file);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public List<String> getDesignResources() {
        lock.readLock().lock();
        try {
            return designResources;
        } finally {
            lock.readLock().unlock();
        }
    }
}
