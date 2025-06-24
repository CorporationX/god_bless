package school.faang.bjs280861;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static final int THREAD_COUNT = 5;
    private static final int TOTAL_MESSAGES = 1000;
    private static final int EMAILS_PER_THREAD = TOTAL_MESSAGES / THREAD_COUNT;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            int startindex = i * EMAILS_PER_THREAD;
            int end = startindex + EMAILS_PER_THREAD;

            threads[i] = new Thread(new Thread(new SenderRunnable(startindex, end)));
            threads[i].start();
        }

        for (Thread thread: threads) {
            thread.join();
        }

        System.out.println("1000 Писем отправлены");


    }
}
