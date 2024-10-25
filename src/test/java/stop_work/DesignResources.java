package stop_work;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DesignResources {
    private final List<String> dFilesNames;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public DesignResources() {
        this.dFilesNames = new ArrayList<>();
    }

    public void printFilesNames() {
        readLock.lock();
        try {
            System.out.println("DesignResources files: " + dFilesNames);
        } finally {
            readLock.unlock();
        }
    }

    public void addFilesNames(String fileName) {
        writeLock.lock();
        try {
            dFilesNames.add(fileName);
            System.out.println("Added file to DesignResources " + fileName);
        } finally {
            writeLock.unlock();
        }
    }
}
