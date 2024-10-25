package stop_work;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MarketingResources {
    private List<String> mFilesNames;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public MarketingResources() {
        this.mFilesNames = new ArrayList<>();
    }

    public void printFilesNames() {
        readLock.lock();
        try {
            System.out.println("MarcetingResourses files: " + mFilesNames);
        } finally {
            readLock.unlock();
        }
    }

    public void addFilesNames(String fileName) {
        writeLock.lock();
        try {
            mFilesNames.add(fileName);
            System.out.println("Added file to DesignResources: " + fileName);
        } finally {
            writeLock.unlock();
        }
    }
}
