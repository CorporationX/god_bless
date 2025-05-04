package school.faang.deadlock;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
@Getter
public class DesignResources {
    private final List<String> files = new ArrayList<>();
    private final ReadWriteLock monitor = new ReentrantReadWriteLock();

    public List<String> readFile() {
        monitor.readLock().lock();
        try {
            System.out.println("Список файлов для проектирования:");
            files.forEach(file -> System.out.println("-" + file));
            return this.files;
        } finally {
            monitor.readLock().unlock();
        }
    }

    public void writeFile(String file) {
        monitor.writeLock().lock();
        try {
            log.info("Запись файлов для проектирования");
            files.add(file);
        } finally {
            monitor.writeLock().unlock();
        }
    }
}
