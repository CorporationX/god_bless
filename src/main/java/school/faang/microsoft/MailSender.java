package school.faang.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static final int TOTAL_MESSAGE_COUNT = 1000;
    public static final int THREADS_COUNT = 5;
    public static final int BATCH_SIZE = TOTAL_MESSAGE_COUNT / THREADS_COUNT;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            int startIndex = i * BATCH_SIZE + 1;
            int endIndex = (i + 1) * BATCH_SIZE;
            SenderRunnable sender = new SenderRunnable(i + 1, startIndex, endIndex);
            Thread thread = new Thread(sender);
            thread.start();
            threads[i] = thread;
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
}
