package faang.school.godbless.jobIsStack;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DesignResources {
    private final List<String> designFiles;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public DesignResources() {
        this.designFiles = new ArrayList<>();
    }

    public void readAllFiles() {
        lock.readLock().lock();
        try {
            System.out.println("Design files:");
            System.out.println(designFiles);
        } finally {
            lock.readLock().unlock();
        }
    }

    public void addNewFile(String file) {
        lock.writeLock().lock();
        try {
            designFiles.add(file);
        } finally {
            lock.writeLock().unlock();
        }
    }
}
