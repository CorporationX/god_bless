package faang.school.godbless.workIsStaying;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.StampedLock;

public class Resources {
    protected List<String> files;
    protected StampedLock lock;

    public Resources() {
        lock = new StampedLock();
        files = new ArrayList<>();
    }

    public void read(long millis) {
        long stamp = lock.readLock();
        try {
            System.out.println("reading...");
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlockRead(stamp);
        }
    }
}
