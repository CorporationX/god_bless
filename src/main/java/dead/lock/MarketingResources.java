package dead.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
public class MarketingResources {
    private List<String> marketingFiles = new ArrayList<>(Arrays.asList("File3", "File4"));
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void addFile(String name) {
        lock.writeLock().lock();
        try {
            if (Objects.isNull(name)) {
                log.error("Name can't be null!");
                Thread.currentThread().interrupt();
                throw new IllegalArgumentException();
            }
            log.info("Method addFile block collection and add the file...");
            marketingFiles.add(name);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public synchronized List<String> getMarketingFiles() {
        lock.readLock().lock();
        try {
            log.info("Method getMarketingFiles block and return the collection...");
            return new ArrayList<>(marketingFiles);
        } finally {
            lock.readLock().unlock();
        }
    }
}
