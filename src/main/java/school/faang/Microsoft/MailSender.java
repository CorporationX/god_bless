package school.faang.Microsoft;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MailSender {

    private static final int TOTAL_MESSAGES = 1000;
    private static final int THREADS_COUNT = 5;

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_COUNT);
        int batchSize = TOTAL_MESSAGES / THREADS_COUNT;

        for (int i = 0; i < THREADS_COUNT; i++) {
            int start = i * batchSize;
            int end = (i + 1) * batchSize;
            executorService.submit(new SenderRunnable(start, end));
        }

        executorService.shutdown();

        while (!executorService.isTerminated()) {}
        System.out.println("Done!!!");

    }
}
