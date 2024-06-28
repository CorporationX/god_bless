package faang.school.godbless.work_stands;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Getter
@ToString
public class MarketingResources {
    private final List<String> marketingFiles = new ArrayList<>();
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public List<String> readFiles() {
        readWriteLock.readLock().lock();
        try {
            return marketingFiles;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public void addFile(String file) {
        readWriteLock.writeLock().lock();
        try {
            marketingFiles.add(file);
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }
}
