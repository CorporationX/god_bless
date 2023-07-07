package faang.school.godbless.sprint4.work;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@Data
public class MarketingResources {
    private List<String> files = new ArrayList<>();
    private Semaphore semaphore;

    public MarketingResources(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public void addFile(String fileName) {
        synchronized (files) {
            files.add(fileName);
        }
    }

    public void viewFiles() {
        synchronized (files) {
            System.out.println(files.toString());
        }
    }

    public boolean enter() throws InterruptedException {
        return semaphore.tryAcquire(1, 1, TimeUnit.SECONDS);
    }

    public void release() {
        semaphore.release();
    }
}
