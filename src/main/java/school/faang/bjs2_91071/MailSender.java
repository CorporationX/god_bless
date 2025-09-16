package school.faang.bjs2_91071;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MailSender {
    private static final int COUNT_THREADS = 5;
    private static final int COUNT_MESSAGE = 1000;
    private static final int TERMINATION_TIMEOUT_MINUTES  = 1;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(COUNT_THREADS);
        int batchSize = COUNT_MESSAGE / COUNT_THREADS;

        try {
            for (int i = 0; i < COUNT_THREADS; i++) {
                int startIndex = i * batchSize;
                int endIndex = (i + 1) * batchSize;

                executor.submit(new SenderRunnable(startIndex, endIndex));
            }
        } finally {
            executor.shutdown();
        }

        try {
            if (!executor.awaitTermination(TERMINATION_TIMEOUT_MINUTES , TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("Не все задачи завершились за отведенное время");
        }

        log.info("Все письма успешно отправлены");
    }
}
