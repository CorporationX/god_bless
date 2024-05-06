package faang.school.godbless.work;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Getter
@Setter
public class MarketingResources {
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private List<String> folder = new ArrayList<>();

    public String getNameOfDocument(int index){
        lock.readLock().lock();
        try {
            return folder.get(index);
        } finally {
            lock.readLock().unlock();
        }
    }

    public void writeNameOfDocument(String name) {
        lock.writeLock().lock();
        try {
            folder.add(name);
        } finally {
            lock.writeLock().unlock();
        }
    }
}
