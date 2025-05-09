package school.faang.work_stop;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DesignResources {
    private final List<String> nameFile = new ArrayList<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public List<String> readeDesign() {
        lock.readLock().lock();
        try {
            return nameFile;
        } finally {
            lock.readLock().unlock();
        }
    }

    public void addFileDesign(String file) {
        lock.writeLock().lock();
        try {
            nameFile.add(file);
        } finally {
            lock.writeLock().unlock();
        }
    }
}
