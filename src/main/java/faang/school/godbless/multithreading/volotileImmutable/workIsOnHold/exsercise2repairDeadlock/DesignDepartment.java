package faang.school.godbless.multithreading.volotileImmutable.workIsOnHold.exsercise2repairDeadlock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DesignDepartment implements Runnable {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final DesignResources designResources;
    private final MarketingResources marketingResources;

    public DesignDepartment(DesignResources designResources, MarketingResources marketingResources) {
        this.designResources = designResources;
        this.marketingResources = marketingResources;
    }

    @Override
    public void run() {
        //readLock marketingResources
        lock.readLock().lock();
        try {
            System.out.println("Original MARKETING files called from DESIGN DEPARTMENT.class: " + marketingResources.readAllFiles());
            System.out.println("Original DESIGN files called from DESIGN DEPARTMENT.class: " + designResources.readAllFiles());
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
            designResources.addFile("newFile-Design1.txt");
            System.out.println("Added new file from DESIGN DEPARTMENT.");
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
            System.out.println("Final MARKETING files called from DESIGN DEPARTMENT.class: " + marketingResources.readAllFiles());
            System.out.println("Final DESIGN files called from DESIGN DEPARTMENT.class: " + designResources.readAllFiles());
        } finally {
            lock.readLock().unlock();
        }
    }
}
