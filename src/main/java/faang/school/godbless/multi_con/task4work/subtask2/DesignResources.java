package faang.school.godbless.multi_con.task4work.subtask2;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.ArrayList;
import java.util.List;

public class DesignResources {
    private List<String> files = new ArrayList<>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void addFile(String name) {
        lock.writeLock().lock();
        try {
            files.add(name);
            System.out.println("Файл добавлен в дизайн: " + name);
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

