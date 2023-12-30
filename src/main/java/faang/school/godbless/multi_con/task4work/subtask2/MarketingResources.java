package faang.school.godbless.multi_con.task4work.subtask2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MarketingResources {
    private List<String> files = new ArrayList<>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void addFile(String name) {
        lock.writeLock().lock();
        try {
            files.add(name);
            System.out.println("Файл добавлен в маркетинг: " + name);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public List<String> readFiles() {
        lock.readLock().lock();
        try {
            return new ArrayList<>(files);
        } finally {
            lock.readLock().unlock();
        }
    }
}
