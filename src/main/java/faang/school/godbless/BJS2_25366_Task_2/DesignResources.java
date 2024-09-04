package faang.school.godbless.BJS2_25366_Task_2;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Getter
public class DesignResources {
    private List<String> files = new ArrayList<>();
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void readFiles() {
        lock.readLock().lock();
        try {
            System.out.println("Getting files from Design Department");
            files.forEach(s -> System.out.printf("\t%s:\n", s));
        } finally {
            lock.readLock().unlock();
        }
    }


    public void addFile(String fileName) {
        lock.writeLock().lock();
        try {
            files.add(fileName);
            System.out.printf("Added Design Resource file: %s\n", fileName);
        } finally {
            lock.writeLock().unlock();
        }
    }

}
