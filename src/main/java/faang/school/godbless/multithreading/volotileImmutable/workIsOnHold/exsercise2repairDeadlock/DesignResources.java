package faang.school.godbless.multithreading.volotileImmutable.workIsOnHold.exsercise2repairDeadlock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class DesignResources {
    private List<String> fileNames = new ArrayList<>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public List<String> readAllFiles() {
        lock.readLock().lock();
        try {
            return fileNames;
        } finally {
            lock.readLock().unlock();
        }
    }

    public void addFile(String file) {
        lock.writeLock().lock();
        try {
            fileNames.add(file);
        } finally {
            lock.writeLock().unlock();
        }
    }
}
