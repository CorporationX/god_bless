package faang.school.godbless.workStands;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DesignResources {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final List<String> resources = new ArrayList<>();

    public void addRecourse(@NonNull String resource) {
        lock.writeLock().lock();
        resources.add(resource);
        lock.writeLock().unlock();
    }

    public List<String> getResources() {
        lock.readLock().lock();
        List<String> out = new ArrayList<>(resources);
        lock.readLock().unlock();
        return out;
    }
}
