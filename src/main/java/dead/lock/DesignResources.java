package dead.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
public class DesignResources {
    private List<String> designFiles = new ArrayList<>(Arrays.asList("File1", "File2"));
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
            designFiles.add(name);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public List<String> getDesignFile() {
        lock.readLock().lock();
        try {
            log.info("Method getDesignFile block and return the collection...");
            return new ArrayList<>(designFiles);
        } finally {
            lock.readLock().unlock();
        }
    }
}
