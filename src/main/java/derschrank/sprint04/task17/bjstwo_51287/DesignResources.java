package derschrank.sprint04.task17.bjstwo_51287;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DesignResources implements Resources {
    private final List<File> files;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public DesignResources() {
        files = new ArrayList<>();
    }

    @Override
    public void addFile(File file) {
        lock.writeLock().lock();
        try {
            files.add(file);
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public List<File> getFiles() {
        lock.readLock().lock();
        try {
            return new ArrayList<>(files);
        } finally {
            lock.readLock().unlock();
        }
    }
}
