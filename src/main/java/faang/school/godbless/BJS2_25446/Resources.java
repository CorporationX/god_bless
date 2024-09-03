package faang.school.godbless.BJS2_25446;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@RequiredArgsConstructor
public class Resources {
    private final List<String> resources;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public void addResource(String resource) {
        lock.writeLock().lock();
        try {
            resources.add(resource);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void getResources() {
        lock.readLock().lock();
        try {
            System.out.println(resources.toString());
        } finally {
            lock.readLock().unlock();
        }
    }
}
