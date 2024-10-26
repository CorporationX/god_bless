package school.faang.work.is.in.place;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DesignResources {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final List<String> fileNames = new ArrayList<>();

    public void addFileName(String fileName) {
        lock.writeLock().lock();
        try {
            System.out.println("Операция записи: дизайн");
            fileNames.add(fileName);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public List<String> getFileNames() {
        lock.readLock().lock();
        try {
            System.out.println("Операция чтения: дизайн");
            return new ArrayList<>(fileNames);
        } finally {
            lock.readLock().unlock();
        }
    }
}
