package work.waiting.departments.resources;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
public class Resources {
    private final List<String> files = new ArrayList<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public synchronized String getFile() {
        lock.readLock().lock();
        String file = files.get(ThreadLocalRandom.current().nextInt(files.size()));
        lock.readLock().unlock();
        return file;
    }

    public synchronized void addFile(@NonNull String file) {
        lock.writeLock().lock();
        files.add(file);
        lock.writeLock().unlock();
    }

    public void printAllFiles() {
        files.forEach(log::info);
    }
}
