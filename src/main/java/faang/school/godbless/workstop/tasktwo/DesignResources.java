package faang.school.godbless.workstop.tasktwo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DesignResources {

    private final List<String> FILES = new ArrayList<>();
    private final List<String> NAMES = new ArrayList<>();
    private final ReentrantReadWriteLock LOCK = new ReentrantReadWriteLock();

    public List<String> getNames() {
        LOCK.readLock().lock();
        try {
            return NAMES;
        } finally {
            LOCK.readLock().unlock();
        }
    }

    public void addName(String name) {
        validateName(name);
        LOCK.writeLock().lock();
        try {
            NAMES.add(name);
        } finally {
            LOCK.writeLock().unlock();
        }
    }

    private void validateName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name can't be null");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name can't be empty");
        }
    }
}
