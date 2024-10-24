package school.faang.workstopped;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DesignResources {
    private final List<String> files = new ArrayList<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();


    public void addFile(String file) {
        lock.writeLock().lock();
        try {
            files.add(file);
            System.out.println("Design resource added: " + file);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public List<String> getFiles() {
        lock.readLock().lock(); // Блокировка для чтения
        try {
            return new ArrayList<>(files);
        } finally {
            lock.readLock().unlock();
        }
    }
}