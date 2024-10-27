package school.faangSprint4.t15;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DesignResourcesSafe {
    private static final int SLEEP_TIME = 100;
    private final List<String> files = new ArrayList<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public void readFiles() {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " читает файлы дизайна: " + files);
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }

    public void writeFile(String filename) {
        lock.writeLock().lock();
        try {
            files.add(filename);
            System.out.println(Thread.currentThread().getName() + " записывает файл дизайна: " + filename);
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
}