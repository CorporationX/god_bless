package school.faang.task_51307;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
public class DesignResources {
    private final List<String> fileNames = new ArrayList<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public synchronized void addFileName(String fileName) {
        lock.writeLock().lock();
        try {
            fileNames.add(fileName);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public List<String> getFileNames() {
        lock.readLock().lock();
        try {
            return fileNames;
        } finally {
            lock.readLock().unlock();
        }
    }
}
