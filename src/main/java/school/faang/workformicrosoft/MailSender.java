package school.faang.workformicrosoft;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MailSender {
    private static final int TOTAL_MESSAGES = 1000;
    private static final int THREADS_COUNT = 5;

    public static void main(String[] args) {
        int batchSize = TOTAL_MESSAGES / THREADS_COUNT;

        ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);

        for (int i = 0; i < THREADS_COUNT; i++) {
            int start = i * batchSize;
            int end = (i + 1) * batchSize;

            executor.submit(new SenderRunnable(start, end));
        }

        executor.shutdown();
    }
}
