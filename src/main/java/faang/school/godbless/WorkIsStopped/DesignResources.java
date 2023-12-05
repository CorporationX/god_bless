package faang.school.godbless.WorkIsStopped;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
@Data
public class DesignResources {
    private List<String> files = new ArrayList<>();
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void readFiles(){
        lock.readLock().lock();
        System.out.println(Thread.currentThread().getId() + "| DesignResources readFiles: " + files);
        lock.readLock().unlock();
    }

    public void writeFiles(String file){
        lock.writeLock().lock();
        files.add(file);
        System.out.println(Thread.currentThread().getId() + "| DesignResources writeFiles: " + file);
        lock.writeLock().unlock();
    }
}
