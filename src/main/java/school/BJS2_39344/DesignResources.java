package school.BJS2_39344;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DesignResources {

    private final List<String> namesOfFiles = new ArrayList<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public synchronized List<String> getList() {
        lock.readLock().lock();
        try {
            return namesOfFiles;
        } finally {
            lock.readLock().unlock();
        }
    }

    public synchronized void addNameOfFile(String name) {
        lock.writeLock().lock();
        try {
            namesOfFiles.add(name);
        } finally {
            lock.writeLock().unlock();
        }
    }

}
