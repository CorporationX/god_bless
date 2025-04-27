package school.faang.workatmicrosoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static final int TOTAL_MESSAGES = 1000;
    private static final int THREADS_COUNT = 5;

    public static void main(String[] args) throws InterruptedException {
        int batchSize = TOTAL_MESSAGES / THREADS_COUNT;
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < THREADS_COUNT; i++) {
            int start = i * batchSize;
            int end = start + batchSize;
            Thread thread = new Thread(new SenderRunnable(start, end));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Все письма отправлены!");
    }
}
