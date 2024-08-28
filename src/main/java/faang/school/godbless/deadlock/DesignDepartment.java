package faang.school.godbless.deadlock;

import lombok.AllArgsConstructor;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@AllArgsConstructor
public class DesignDepartment extends Thread {
    private MarketingResources marketingResources;
    private DesignResources designResources;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    private void work() {
        lock.writeLock().lock();
        designResources.writeFiles("Design department started working");
        lock.writeLock().unlock();

        lock.readLock().lock();
        marketingResources.readFiles();
        lock.readLock().unlock();

        lock.writeLock().lock();
        designResources.writeFiles("Design department adding files" +
                " after looking at marketing resources");
        lock.writeLock().unlock();
    }

    @Override
    public void run() {
        work();
    }
}
