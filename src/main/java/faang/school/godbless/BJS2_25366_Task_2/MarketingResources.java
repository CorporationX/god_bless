package faang.school.godbless.BJS2_25366_Task_2;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Getter
public class MarketingResources {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private List<String> files = new ArrayList<>();

    public void readFiles() {
        lock.readLock().lock();
        try {
            System.out.println("Getting files from Marketing Department");
            files.forEach(s -> System.out.printf("\t%s:\n", s));
        } finally {
            lock.readLock().unlock();
        }
    }

    public void addFile(String file) {
        lock.writeLock().lock();
        try {
            files.add(file);
            System.out.printf("Added new file to marketing files: %s\n", file);
        } finally {
            lock.writeLock().unlock();
        }
    }
}