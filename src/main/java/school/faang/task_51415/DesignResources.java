package school.faang.task_51415;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DesignResources {
    private final List<String> files = new ArrayList<>();
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void readFiles() {
        lock.readLock().lock();
        try {
            System.out.println("Design files: " + files);
        } finally {
            lock.readLock().unlock();
        }
    }

    public void addFile(String file) {
        lock.writeLock().lock();
        try {
            files.add(file);
            System.out.println("Added design file: " + file);
        } finally {
            lock.writeLock().unlock();
        }
    }
}
