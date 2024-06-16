package faang.school.godbless.multithreading;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Chore implements Runnable {

    private static final int SLEEP_TIME = 1000;

    private String chore;

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("chore " + chore + " is done in thread: " + threadName);
    }
}
