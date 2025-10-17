package school.faang.bjs2_93333;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
@Getter
@Setter
public class DesignResources {
    private final List<String> files = new ArrayList<>();
    ReadWriteLock lock = new ReentrantReadWriteLock();

    void addFile(@NonNull String file) {
        try {
            lock.writeLock().lock();
            files.add(file);
            log.info("{} добавлен в Design Resources.", file);
        } finally {
            lock.writeLock().unlock();
        }
    }

    void readAllFiles() {
        try {
            lock.readLock().lock();
            for (String file : files) {
                log.info("Design file: {}", file);
            }
        } finally {
            lock.readLock().unlock();
        }
    }
}
