package school.faang.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static final int TOTAL_MESSAGE_COUNT = 1000;
    public static final int THREADS_COUNT = 5;

    public static void main(String[] args) throws InterruptedException {
        int batchSize = TOTAL_MESSAGE_COUNT / THREADS_COUNT;
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            SenderRunnable sender = new SenderRunnable(i + 1,
                    (i * batchSize) + 1, (i + 1) * batchSize);
            Thread thread = new Thread(sender);
            thread.start();
            threads[i] = thread;
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
}
