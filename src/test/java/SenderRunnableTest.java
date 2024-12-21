import org.junit.jupiter.api.Test;
import school.faang.bjs248406.SenderRunnable;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SenderRunnableTest {
    @Test
    public void testThreadExecutions() {
        SenderRunnable.resetCounterThread();
        int startIndex = 1;
        int finishIndex = 200;
        int step = 200;
        Thread[] threads = new Thread[5];
        try {
            for (int i = 0; i < threads.length; i++) {
                threads[i] = new Thread(new SenderRunnable(startIndex, finishIndex));
                threads[i].start();
                startIndex += step;
                finishIndex += step;
            }
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted: " + e.getMessage());
            e.printStackTrace();
        }
        assertTrue(SenderRunnable.allThreadsCompleted(threads.length), "Not all threads in time");
    }
}
