import org.junit.jupiter.api.Test;
import school.faang.bjs248406.SenderRunnable;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SenderRunnableTest {
    @Test
    public void testThreadExecutions() {
        SenderRunnable.resetCounterThread();
        int startIndex = 1;
        int finishIndex = 200;
        Thread[] threads = new Thread[5];
        try {
            for (int i = 0; i < 5; i++) {
                threads[i] = new Thread(new SenderRunnable(startIndex, finishIndex));
                threads[i].start();
                startIndex += 200;
                finishIndex += 200;
            }
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assertTrue(SenderRunnable.allThreadsCompleted(threads.length), "Not all threads in time");
    }
}
