package faang.school.godbless.workisstopping;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
public class MarketingResources {
    private final List<String> files;
    private final ReentrantReadWriteLock lock;

    public MarketingResources() {
        this.files = new ArrayList<>();
        this.lock = new ReentrantReadWriteLock();
    }

    public synchronized void addFile(String fileName) {
        lock.writeLock().lock();
        try {
            log.info("Marketing Department is adding file: {}", fileName);
            files.add(fileName);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public synchronized void getFiles() {
        lock.readLock().lock();
        try {
            log.info("Marketing Department is browsing the files.");
        } finally {
            lock.readLock().unlock();
        }
    }
}