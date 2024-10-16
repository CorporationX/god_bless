package school.faang.godbless.bjs2_36735;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Chore implements Runnable {
    private static final int TIMEOUT = 500;

    private final String chore;

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("Thread " + threadName + " is doing chore " + chore);
        try {
            Thread.sleep(TIMEOUT);
        } catch (InterruptedException e) {
            throw new RuntimeException("Thread interrupted during sleep");
        }
    }
}
