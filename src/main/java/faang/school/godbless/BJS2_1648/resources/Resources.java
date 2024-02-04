package faang.school.godbless.BJS2_1648.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public abstract class Resources {
    private final List<String> files = new ArrayList<>();
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void addFile(String file) {
        Lock writeLock = readWriteLock.writeLock();
        writeLock.lock();
        try {
            files.add(file);
        } finally {
            writeLock.unlock();
        }
    }

    public void printFiles() {
        Lock readLock = readWriteLock.readLock();
        readLock.lock();
        try {
            files.forEach(System.out::println);
        } finally {
            readLock.unlock();
        }
    }
}
