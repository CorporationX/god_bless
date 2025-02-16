package school.faang.outlook;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MailSender {

    private static final int THREADS_COUNT = 5;
    private static final int TOTAL_MESSAGES_COUNT = 1000;

    public static void main(String[] args) {

        int batchSize = TOTAL_MESSAGES_COUNT / THREADS_COUNT;
        ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);

        for (int i = 0; i < 5; i++) {
            int start = i * batchSize + 1;
            int finish = (i + 1) * batchSize;
            executor.submit(() -> new SenderRunnable(start, finish).run());
        }
        executor.shutdown();
    }
}
