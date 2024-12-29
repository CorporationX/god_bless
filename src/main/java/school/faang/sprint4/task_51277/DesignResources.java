package school.faang.sprint4.task_51277;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
@RequiredArgsConstructor
public class DesignResources {
    private static final int SLEEP_TIME = 1000;

    private final List<String> files = new ArrayList<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public void addNewFile(@NonNull String file) {
        lock.writeLock().lock();
        files.add(file);
        log.info("New design: {} was added", file);
        lock.writeLock().unlock();
    }

    public List<String> getFiles() {
        lock.readLock().lock();
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lock.readLock().unlock();
        return files;
    }
}
