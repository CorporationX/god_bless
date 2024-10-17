package school.faang.multithreadingcachedthreadpool;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Chore implements Runnable {
    private final static int SLEEP_TIME_MS = 300;
    private String chore;
    private final int sleepTimeMs;

    public Chore(String chore) {
        this(chore, SLEEP_TIME_MS);
    }

    public Chore(String chore, int sleepTimeMs) {
        this.chore = chore;
        this.sleepTimeMs = sleepTimeMs;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " - start");
            Thread.sleep(sleepTimeMs);
            System.out.println(Thread.currentThread().getName() + "Chore: " + getChore() + " - end");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " - crashed");
            e.printStackTrace();
        }
    }
}
