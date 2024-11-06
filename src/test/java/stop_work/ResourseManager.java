package stop_work;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public abstract class ResourseManager {
    private List<String> filesNames;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public ResourseManager() {
        this.filesNames = new ArrayList<>();
    }
    public void printFilesNames() {
        readLock.lock();
        try {
            System.out.println(getResourceType() + "files: " + filesNames);
        } finally {
            readLock.unlock();
        }
    }
    public void addFilesNames(String fileName) {
        writeLock.lock();
        try {
            filesNames.add(fileName);
            System.out.println("Added file to: " + getResourceType() + ":" + fileName);
        } finally {
            writeLock.unlock();
        }
    }
    public abstract String getResourceType();
}
