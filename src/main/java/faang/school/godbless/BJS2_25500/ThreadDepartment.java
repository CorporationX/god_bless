package faang.school.godbless.BJS2_25500;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Getter
@AllArgsConstructor
public abstract class ThreadDepartment extends Thread {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private DesignResources designResources;
    private MarketingResources marketingResources;

    protected void process(Resources writeResources, Resources readResources) {
        ReadWriteLock lock = getLock();

        lock.readLock().lock();
        writeResources.printFiles();
        String file = readResources.readFile();
        lock.readLock().unlock();

        lock.writeLock().lock();
        writeResources.writeFile(file);
        lock.writeLock().unlock();
    }
}
