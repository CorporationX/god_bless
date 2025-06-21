package school.faang.bjs2_81215;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Chore implements Runnable {

    private static final int SLEEP_DURATION_MS = 1000;

    private final String chore;

    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + " is performing chore: " + chore);
        try {
            Thread.sleep(SLEEP_DURATION_MS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
