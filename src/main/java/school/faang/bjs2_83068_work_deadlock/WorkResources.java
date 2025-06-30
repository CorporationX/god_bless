package school.faang.bjs2_83068_work_deadlock;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@AllArgsConstructor
public class WorkResources {
    private final List<String> resources;
    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public List<String> readResources() {
        readWriteLock.readLock().lock();
        try {
            return resources;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public void addResource(String resource) {
        readWriteLock.writeLock().lock();
        try {
            resources.add(resource);
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }
}
