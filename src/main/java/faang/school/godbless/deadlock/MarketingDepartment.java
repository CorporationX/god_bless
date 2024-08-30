package faang.school.godbless.deadlock;

import lombok.AllArgsConstructor;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@AllArgsConstructor
public class MarketingDepartment extends Thread {
    private MarketingResources marketingResources;
    private DesignResources designResources;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    private void work() {
        lock.writeLock().lock();
        marketingResources.writeFiles("Marketing department starting working");
        lock.writeLock().unlock();

        lock.readLock().lock();
        designResources.readFiles();
        lock.readLock().unlock();

        lock.writeLock().lock();
        marketingResources.writeFiles("Marketing department adding files" +
                " after looking at design resources");
        lock.writeLock().unlock();
    }

    @Override
    public void run() {
        work();
    }
}
