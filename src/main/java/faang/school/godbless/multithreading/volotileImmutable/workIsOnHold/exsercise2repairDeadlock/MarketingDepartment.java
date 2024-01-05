package faang.school.godbless.multithreading.volotileImmutable.workIsOnHold.exsercise2repairDeadlock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MarketingDepartment implements Runnable {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final MarketingResources marketingResources;
    private final DesignResources designResources;

    public MarketingDepartment(DesignResources designResources, MarketingResources marketingResources) {
        this.marketingResources = marketingResources;
        this.designResources = designResources;
    }

    @Override
    public void run() {
        //readLock marketingResources
        lock.readLock().lock();
        try {
            System.out.println("Original MARKETING files called from MARKETING DEPARTMENT.class: " + marketingResources.readAllFiles());
            System.out.println("Original DESIGN files called from MARKETING DEPARTMENT.class: " + designResources.readAllFiles());
        } finally {
            lock.readLock().unlock();
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.interrupted();
        }

        //writeLock designResources
        lock.writeLock().lock();
        try {
            marketingResources.addFile("newFile-Marketing1.txt");
            System.out.println("Added new file from MARKETING DEPARTMENT.");
        } finally {
            lock.writeLock().unlock();
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.interrupted();
        }

        lock.readLock().lock();
        try {
            System.out.println("Final MARKETING files called from MARKETING DEPARTMENT.class: " + marketingResources.readAllFiles());
            System.out.println("Final DESIGN files called from MARKETING DEPARTMENT.class: " + designResources.readAllFiles());
        } finally {
            lock.readLock().unlock();
        }
    }
}
