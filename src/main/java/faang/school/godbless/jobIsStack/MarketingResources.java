package faang.school.godbless.jobIsStack;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@RequiredArgsConstructor
public class MarketingResources {
    private final List<String> marketingFiles;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public MarketingResources() {
        this.marketingFiles = new ArrayList<>();
    }

    public void readAllFiles() {
        lock.readLock().lock();
        try {
            System.out.println("Marketing files:");
            System.out.println(marketingFiles);
        } finally {
            lock.readLock().unlock();
        }
    }

    public void addNewFile(String file) {
        lock.writeLock().lock();
        try {
            marketingFiles.add(file);
        } finally {
            lock.writeLock().unlock();
        }
    }
}
