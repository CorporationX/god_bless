package faang.school.godbless.BJS2_25600;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DesignResources {
    private final List<String> files = new ArrayList<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public void addFile(String fileName) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " добавляет файл в DesignResources: " + fileName);
            files.add(fileName);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public List<String> getFiles() {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " читает файлы из DesignResources");
            return new ArrayList<>(files);
        } finally {
            lock.readLock().unlock();
        }
    }
}
