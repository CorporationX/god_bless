package school.faang.bjs2_72999;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final int THREADS_COUNT = 5;
    private static final int TOTAL_EMAILS = 1000;
    private static final int BATCH_SIZE = TOTAL_EMAILS / THREADS_COUNT;

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < TOTAL_EMAILS; i += BATCH_SIZE) {
            SenderRunnable senderRunnable = new SenderRunnable(i, i + BATCH_SIZE);
            Thread thread = new Thread(senderRunnable);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error("Thread was interrupted.", e);
            }
        }

        log.info("All threads have finished.");
    }
}
