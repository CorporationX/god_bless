package faang.school.godbless.work_stopped;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MarketingResources {
    private List<String> files;
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public MarketingResources() {
        this.files = new ArrayList<>();
    }

    public void addFile(String path) {
        readWriteLock.writeLock().lock();
        files.add(path);
        readWriteLock.writeLock().unlock();
    }

    public List<String> getFiles() {
        readWriteLock.readLock().lock();
        List<String> data = new ArrayList<>(files);
        readWriteLock.readLock().unlock();
        return data;
    }
}
