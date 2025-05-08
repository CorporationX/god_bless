package school.faang.deadlock;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
@Getter
public class MarketingResources {
    private final List<String> files = new ArrayList<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public List<String> readFile() {
        lock.readLock().lock();
        try {
            log.info("Чтение файлов маркетинга");
            return files;
        } finally {
            lock.readLock().unlock();
        }
    }

    public void writeFile(String file) {
        lock.writeLock().lock();
        try {
            log.info("Запись файлов для маркетинга");
            files.add(file);
        } finally {
            lock.writeLock().unlock();
        }
    }
}
