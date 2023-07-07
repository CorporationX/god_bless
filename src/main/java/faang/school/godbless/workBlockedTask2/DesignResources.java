package faang.school.godbless.workBlockedTask2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DesignResources {
    private final List<String> files;
    private final ReadWriteLock lock;

    public DesignResources(List<String> files) {
        this.files = new ArrayList<>(files);
        this.lock = new ReentrantReadWriteLock();
    }

    public List<String> readFiles() {
        lock.readLock().lock();
        try {
            return new ArrayList<>(files);
        } finally {
            lock.readLock().unlock();
        }
    }

    public void addFile(String fileName) {
        lock.writeLock().lock();
        try {
            files.add(fileName);
        } finally {
            lock.writeLock().unlock();
        }
    }

}
