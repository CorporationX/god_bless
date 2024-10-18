package school.faang.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {

    private static final int MAIL_COUNT = 1000;
    private static final int THREADS_COUNT = 5;

    public static void main(String[] args) {
        int batchSize = MAIL_COUNT / THREADS_COUNT;
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < THREADS_COUNT; i++) {
            int startIndex = i * batchSize;
            int endIndex = (i + 1) * batchSize;
            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new IllegalStateException("Thread was interrupted", e);
            }
        }
        System.out.println("All mails were sent");
    }
}
