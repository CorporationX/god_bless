package school.faang.workSuspended.Fixed;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DesignResources {
    private final List<String> designFiles = new ArrayList<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public void addFile(String file) {
        lock.writeLock().lock();
        try {
            designFiles.add(file);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public List<String> getDesignFiles() {
        lock.readLock().lock();
        try {
            return designFiles;
        } finally {
            lock.readLock().unlock();
        }
    }
}
