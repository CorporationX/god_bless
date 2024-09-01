package faang.school.godbless.BJS2_25358;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DesignResources {
    private final ReadWriteLock designLock = new ReentrantReadWriteLock();
    private final List<String> designResources = generateDesignResources(5);

    public void addDesignResource(String designResource) {
        designLock.writeLock().lock();
        designResources.add(designResource);
        designLock.writeLock().unlock();
    }

    public List<String> getDesignResources() {
        designLock.readLock().lock();
        List<String> result = new ArrayList<>(designResources);
        designLock.readLock().unlock();
        return result;
    }

    public List<String> generateDesignResources(int size) {
        return IntStream.range(0, size)
                .mapToObj(i -> "DesignContent" + i)
                .collect(Collectors.toList());
    }
}
