package school.faang.workstopped;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DesignResources {
    private final List<String> files = new ArrayList<>();
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public List<String> readFiles() {
        lock.readLock().lock();
        try {
            System.out.println("Reading files from Design Resources");
            return new ArrayList<>(files);
        } finally {
            lock.readLock().unlock();
        }
    }

    public void addFile(String fileName) {
        lock.writeLock().lock();
        try {
            System.out.println("Adding file to Design Resources: " + fileName);
            files.add(fileName);
        } finally {
            lock.writeLock().unlock();
        }
    }
}
